package qiqihaer.desk.www.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.*;
import qiqihaer.desk.www.entity.User;
import qiqihaer.desk.www.entitytmp.Post;
import qiqihaer.desk.www.entitytmp.PostComment;
import qiqihaer.desk.www.entitytmp.PostFavort;
import qiqihaer.desk.www.entitytmp.PostImage;
import qiqihaer.desk.www.service.GoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoServiceimpl implements GoService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostCommentMapper postCommentMapper;
    @Autowired
    private PostFavortMapper postFavortMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostImageMapper postImageMapper;
    @Override
    public List<Post> QueryPost(int pageIndex, int pageSize) {


        List<Post> tmp = new ArrayList<>();
        PageHelper.startPage(pageIndex, pageSize); //开始起始页
        List<Post> l = postMapper.select(new Post());
/*
        if (pageIndex !=0 ){
            if (l.size()< (pageIndex+1)*pageSize ){
                return null;
            }
        }
*/
        for (int i = 0; i <= l.size()-1 ; i++) {
            Post tmpPost = new Post();
            Post lp = l.get(i);

            tmpPost.setId(lp.getId());
            tmpPost.setContent(lp.getContent());
            tmpPost.setCreateTime(lp.getCreateTime());
            tmpPost.setType(lp.getType());

            tmpPost.setLinkImg(lp.getLinkImg() == null ? "":lp.getLinkImg());
            tmpPost.setLinkTitle(lp.getLinkTitle() == null ? "":lp.getLinkTitle());
            tmpPost.setLinkUrl(lp.getLinkUrl() == null ? "" : lp.getLinkUrl());
            tmpPost.setLinkDesc(lp.getLinkDesc() == null ? "":lp.getLinkDesc());
            tmpPost.setVideoUrl(lp.getVideoUrl() == null ? "": lp.getVideoUrl());
            tmpPost.setAuthorId(lp.getAuthorId());
            tmpPost.setVideoImgUrl(lp.getVideoImgUrl() == null ? "":lp.getVideoImgUrl());

            Integer author_id = l.get(i).getAuthorId();//得到post表中的author_id
            Integer belongid = l.get(i).getId();//得到post表中的主键id,作为post_comment,post_favort表的belong_id属相
            User user = new User();
            user.setId(author_id);
            User author = userMapper.selectOne(user);//得到发说说的对象

            if (author == null){
                System.out.println("author is null");
            }
            tmpPost.setAuthor(author);

            PostImage postImage = new PostImage();
            postImage.setBelongId(belongid);//根据belongid查出所有有关的postimage对象
            List<PostImage> poimg = postImageMapper.select(postImage);
            List<PostImage> postImageList = new ArrayList<>();
            for (int j = 0; j <poimg.size() ; j++) {
                PostImage postImage1 = new PostImage();
                postImage1.setId(poimg.get(j).getId());
                postImage1.setUrl(poimg.get(j).getUrl() == null ? "" : poimg.get(j).getUrl());
                postImage1.setSize(poimg.get(j).getSize() == null ? "" :poimg.get(j).getSize());
                postImage1.setName(poimg.get(j).getName() == null ? "" : poimg.get(j).getName());
                postImage1.setBelongId(belongid);
                postImage1.setBelong(lp);/////////////
                postImageList.add(postImage1);
            }
            tmpPost.setPostImages(postImageList);


            PostComment postComment = new PostComment();
            postComment.setBelongId(belongid);//根据belongid查出所有有关的postcomment对象
            List<PostComment> pocom = postCommentMapper.select(postComment);

            List<PostComment> postComments = new ArrayList<>();
            for (int j = 0; j <pocom.size() ; j++) {
                PostComment postComment1 = new PostComment();
                postComment1.setId(pocom.get(j).getId());
                postComment1.setUserId(pocom.get(j).getUserId());
                postComment1.setBelongId(pocom.get(j).getBelongId());
                postComment1.setToReplyUserId(pocom.get(j).getToReplyUserId());

                //postComment1.setType(pocom.get(j).getType());
                postComment1.setType(pocom.get(j).getCtype());

                Integer uid = pocom.get(j).getUserId();
                User uh = userMapper.selectByPrimaryKey(uid);
                postComment1.setUser(uh);
                Integer toreplyuserid = pocom.get(j).getToReplyUserId();
                User replyuser = userMapper.selectByPrimaryKey(toreplyuserid);
                postComment1.setToreplyuser(replyuser);
                postComment1.setContent(pocom.get(j).getContent());
                postComment1.setBelong(lp);//////////
                postComments.add(postComment1);
            }
            tmpPost.setPostComments(postComments);



            PostFavort postFavort = new PostFavort();
            postFavort.setBelongId(belongid);
            List<PostFavort> pofav = postFavortMapper.select(postFavort);

            List<PostFavort> postFavorts = new ArrayList<>();
            for (int j = 0; j <pofav.size() ; j++) {
                PostFavort p = new PostFavort();
                p.setId(pofav.get(j).getId());
                p.setUserId(pofav.get(j).getUserId());
                p.setBelongId(pofav.get(j).getBelongId());
                Integer userid = pofav.get(j).getUserId();
                User u = userMapper.selectByPrimaryKey(userid);
                p.setUser(u);
                ////////
                //////////
                p.setBelong(lp);
                postFavorts.add(p);
            }
            tmpPost.setPostFavorts(postFavorts);
            tmp.add(tmpPost);
        }
        return tmp;
    }

    @Override
    public int InsertVideoPost(Post post) {
        return postMapper.insertSelective(post);
    }

    @Override
    public Post QueryOneVideoPost(Post post) {
        Post p = postMapper.selectOne(post);
        Integer authorid = p.getAuthorId();
        User Author = userMapper.selectByPrimaryKey(authorid);
        p.setAuthor(Author);
        return p;
    }

    @Override
    public void InsertImagePost(int authorId, List<String> images) {
        for (String image : images){
            PostImage postImage = new PostImage();
            postImage.setBelongId(authorId);
            postImage.setName(image);
            postImage.setUrl(image);
            postImage.setSize("#l#m#s");
            postImageMapper.insert(postImage);
        }
    }

    @Override
    public Post QueryOneImagePost(Post post) {
        Post p = postMapper.selectOne(post);
        User u = userMapper.selectByPrimaryKey(p.getAuthorId());
        p.setAuthor(u);

        PostImage postImage = new PostImage();
        postImage.setBelongId(p.getId());
        List<PostImage> postImageList = new ArrayList<>();
        List<PostImage> postimages = postImageMapper.select(postImage);
        for (PostImage postImage1 : postimages){
            postImage1.setBelong(p);
            postImageList.add(postImage1);
        }
        p.setPostImages(postImageList);
        return p;
    }

    @Override
    public Post QueryNoImagePost(Post post) {
        Post p = postMapper.selectOne(post);
        User author = userMapper.selectByPrimaryKey(p.getAuthorId());
        p.setAuthor(author);
        return p;
    }

    @Override
    public int FindPostId(Post post) {
        Post p = postMapper.selectOne(post);

        return p.getId();
    }

    @Override
    public int InsertFavort(PostFavort postFavort) {
        int i = postFavortMapper.insertSelective(postFavort);
        return i;
    }

    @Override
    public int ReturnFavortId(PostFavort postFavort) {
        PostFavort p = postFavortMapper.selectOne(postFavort);
        return p.getId();
    }

    @Override
    public Post FindPostbyPrimaryKey(int postid) {
        return postMapper.selectByPrimaryKey(postid);
    }

    @Override
    public int DeleteFavort(PostFavort postFavort) {
        return postFavortMapper.delete(postFavort);
    }

    @Override
    public int InsertPostComment(PostComment postComment) {
        return postCommentMapper.insertSelective(postComment);
    }

    @Override
    public PostComment ReturnCommentLastOne() {
        List<PostComment> j = postCommentMapper.select(new PostComment());
        return j.get(j.size()-1);
    }

    @Override
    public int DeleteComment(int commentId) {
        return postCommentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public int DeletePost(Post post) {
        return postMapper.delete(post);
    }
}
