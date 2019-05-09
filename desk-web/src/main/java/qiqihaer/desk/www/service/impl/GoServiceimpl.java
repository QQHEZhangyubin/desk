package qiqihaer.desk.www.service.impl;

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
        List<Post> l = postMapper.select(new Post());
        for (int i = 0; i <l.size() ; i++) {
            Post tmpPost = new Post();
            Post lp = l.get(i);

            tmpPost.setId(lp.getId());
            tmpPost.setContent(lp.getContent());
            tmpPost.setCreateTime("54545");
            tmpPost.setType(lp.getType());
            tmpPost.setLinkImg(lp.getLinkImg());
            tmpPost.setLinkTitle(lp.getLinkTitle());
            tmpPost.setLinkUrl(lp.getLinkUrl());
            tmpPost.setLinkDesc(lp.getLinkDesc());
            tmpPost.setVideoUrl(lp.getVideoUrl());
            tmpPost.setVideoImgUrl(lp.getVideoImgUrl());
            Integer author_id = l.get(i).getAuthorId();//得到post表中的author_id

            User user = new User();
            user.setId(author_id);
            User author = userMapper.selectOne(user);//得到发说说的对象

            if (author == null){
                System.out.println("author is null");
            }
            tmpPost.setAuthor(author);

            PostImage postImage = new PostImage();
            postImage.setBelongId(author_id);//根据author_id查出所有有关的postimage对象
            List<PostImage> poimg = postImageMapper.select(postImage);
            List<PostImage> postImageList = new ArrayList<>();
            for (int j = 0; j <poimg.size() ; j++) {
                PostImage postImage1 = new PostImage();
                postImage1.setId(poimg.get(j).getId());
                postImage1.setUrl(poimg.get(j).getUrl());
                postImage1.setSize(poimg.get(j).getSize());
                postImage1.setName(poimg.get(j).getName());
                postImage1.setBelong(lp);
                postImageList.add(postImage1);
            }
            tmpPost.setPostImages(postImageList);


            PostComment postComment = new PostComment();
            postComment.setBelongId(author_id);//根据author_id查出所有有关的postcomment对象
            List<PostComment> pocom = postCommentMapper.select(postComment);

            List<PostComment> postComments = new ArrayList<>();
            for (int j = 0; j <pocom.size() ; j++) {
                PostComment postComment1 = new PostComment();
                postComment1.setId(pocom.get(j).getId());
                postComment1.setType(pocom.get(j).getType());
                Integer uid = pocom.get(j).getUserId();
                User uh = userMapper.selectByPrimaryKey(uid);
                postComment1.setUser(uh);
                Integer toreplyuserid = pocom.get(j).getToReplyUserId();
                User replyuser = userMapper.selectByPrimaryKey(toreplyuserid);
                postComment1.setToreplyuser(replyuser);
                postComment1.setContent(pocom.get(j).getContent());
                postComment1.setBelong(lp);
                postComments.add(postComment1);
            }
            tmpPost.setPostComments(postComments);



            PostFavort postFavort = new PostFavort();
            postFavort.setBelongId(author_id);
            List<PostFavort> pofav = postFavortMapper.select(postFavort);

            List<PostFavort> postFavorts = new ArrayList<>();
            for (int j = 0; j <pofav.size() ; j++) {
                PostFavort p = new PostFavort();
                p.setId(pofav.get(j).getId());
                Integer userid = pofav.get(j).getUserId();
                User u = userMapper.selectByPrimaryKey(userid);
                p.setUser(u);
                Integer belongid = pofav.get(j).getBelongId();
                p.setBelong(lp);
                postFavorts.add(p);
            }
            tmpPost.setPostFavorts(postFavorts);
            tmp.add(tmpPost);
        }
        return tmp;
    }
}
