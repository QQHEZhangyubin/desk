package qiqihaer.desk.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import qiqihaer.desk.www.entity.User;
import qiqihaer.desk.www.entitytmp.Post;
import qiqihaer.desk.www.entitytmp.PostComment;
import qiqihaer.desk.www.entitytmp.PostFavort;
import qiqihaer.desk.www.service.GoService;
import qiqihaer.desk.www.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("api/post")
public class GoController {
    @Autowired
    private GoService goService;
    @Autowired
    private UserService userService;

    @RequestMapping("/read/postlist")
    @ResponseBody
    public Map<String,Object>  GetPostList(@RequestParam(value = "pageIndex",required = false) String pageIndex,
                                           @RequestParam(value = "pageSize",required = false) String pageSize){
        Map map = new HashMap<String,Object>();
        System.out.println("pageIndex = " + pageIndex + ", pageSize = " + pageSize);
        List<Post> l = goService.QueryPost(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
        //得到post集合
        map.put("Msg","success");
        map.put("Is",100);
        map.put("Data",l);
        System.out.println(map);
        return map;
    }

    @RequestMapping("/create/post")
    @ResponseBody
    public Map<String,Object> GetVideoPost(
                                            @RequestParam(value = "userId",required = false) String userId,
                                            @RequestParam(value = "type",required = false) String type,
                                            @RequestParam(value = "content",required = false) String content,
                                            @RequestParam(value = "videourl",required = false) String videourl,
                                            @RequestParam(value = "imgshooturl",required = false) String imgshooturl,
                                            @RequestParam(value = "video" ,required = false) CommonsMultipartFile video,
                                            @RequestParam(value = "videoImg" ,required = false) CommonsMultipartFile videoimg){
        Map map = new HashMap<String,Object>();
        System.out.println(content);
        System.out.println(userId);
        System.out.println(type);
        System.out.println(videourl);
        System.out.println(imgshooturl);
        //System.out.println(video.getOriginalFilename());
        //System.out.println(videoimg.getOriginalFilename());
        map.put("Msg","success");
        map.put("Is",100);

        /*
        try {
            video.transferTo(new File("E:\\picture",video.getOriginalFilename()));
            videoimg.transferTo(new File("E:\\picture",videoimg.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        Post post = new Post();
        post.setAuthorId(Integer.parseInt(userId));
        post.setCreateTime(new Date()+"");
        post.setContent(content);
        //post.setVideoUrl(FileUploadController.baseUrl + video.getOriginalFilename());
        //post.setVideoImgUrl(FileUploadController.baseUrl + videoimg.getOriginalFilename());
        post.setVideoUrl(videourl);
        post.setVideoImgUrl(imgshooturl);
        post.setType(Integer.parseInt(type));
        if (1 == goService.InsertVideoPost(post)){
            Post post1 = new Post();
            post1.setContent(content);
            post.setVideoUrl(videourl);
            post.setVideoImgUrl(imgshooturl);
            post1.setAuthorId(Integer.parseInt(userId));
            Post kj = goService.QueryOneVideoPost(post1);
            map.put("Data",kj);
        }
        return map;
    }

    @RequestMapping("/create/post1")
    @ResponseBody
    public Map<String,Object> GetImagePost(@RequestParam(value = "content" ,required = false) String content,
                                           @RequestParam(value = "userId",required = false) String userId,
                                           @RequestParam(value = "type",required = false) String type,
                                           @RequestParam(value = "imgs",required = false) String imgs,
                                           @RequestParam(value = "haveimg",required = false) String having,

                                           @RequestParam(value = "photos",required = false) CommonsMultipartFile []commonsMultipartFiles){

        System.out.println(content);
        System.out.println(userId);
        System.out.println(type);
        System.out.println(having);
        System.out.println(imgs);

        Map map = new HashMap<String,Object>();
        map.put("Msg","success");
        map.put("Is",100);
        if (having.equals("have")){
            String[] ims = imgs.split(",");
            List<String> d = Arrays.asList(ims);

            Post post = new Post();
            post.setContent(content);
            post.setCreateTime(new Date() + "");
            post.setAuthorId(Integer.parseInt(userId));
            post.setType(Integer.parseInt(type));
            if (1 == goService.InsertVideoPost(post)){
                int postid = goService.FindPostId(post);
                goService.InsertImagePost(postid,d);
                Post pl = goService.QueryOneImagePost(post);
                map.put("Data",pl);
            }
            /*
            for(CommonsMultipartFile c: commonsMultipartFiles){
                try {
                    c.transferTo(new File("E:\\picture",c.getOriginalFilename()));
                    images.add(FileUploadController.baseUrl+c.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Post post = new Post();
            post.setContent(content);
            post.setCreateTime(new Date() + "");
            post.setAuthorId(Integer.parseInt(userId));
            post.setType(Integer.parseInt(type));
            if (1 == goService.InsertVideoPost(post)){
                int postid = goService.FindPostId(post);
                goService.InsertImagePost(postid,images);
                Post pl = goService.QueryOneImagePost(post);
                map.put("Data",pl);
            }
            */
        }else {
            Post post = new Post();
            post.setContent(content);
            post.setCreateTime(new Date() + "");
            post.setAuthorId(Integer.parseInt(userId));
            post.setType(Integer.parseInt(type));
            if (1 == goService.InsertVideoPost(post)){
                Post pl = goService.QueryNoImagePost(post);
                map.put("Data",pl);
            }
        }

        return map;
    }

    @RequestMapping("/create/favort")
    @ResponseBody
    public Map<String,Object> AddFavort(@RequestParam(value = "userId",required = false) String userId,
                                        @RequestParam(value = "postId",required = false) String postId){
        System.out.println(userId);
        System.out.println(postId);
        Map map = new HashMap<String,Object>();
        map.put("Msg","success");
        map.put("Is",100);
        PostFavort postFavort = new PostFavort();
        postFavort.setUserId(Integer.parseInt(userId));
        postFavort.setBelongId(Integer.parseInt(postId));
        if (1 == goService.InsertFavort(postFavort)){
            int favortid = goService.ReturnFavortId(postFavort);
            User user = userService.findUserbyPrimaryKey(Integer.parseInt(userId));
            Post post = goService.FindPostbyPrimaryKey(Integer.parseInt(postId));
            PostFavort postFavort1 = new PostFavort();
            postFavort1.setId(favortid);
            postFavort1.setUser(user);
            postFavort1.setBelong(post);
            map.put("Data",postFavort1);
        }
        return map;
    }

    @RequestMapping("/delete/favort")
    @ResponseBody
    public Map<String,Object> DeleteFavort(@RequestParam(value = "userId",required = false) String userId,
                                        @RequestParam(value = "postId",required = false) String postId){
        System.out.println(userId);
        System.out.println(postId);
        Map map = new HashMap<String,Object>();
        map.put("Msg","success");
        map.put("Is",100);
        PostFavort postFavort = new PostFavort();
        postFavort.setUserId(Integer.parseInt(userId));
        postFavort.setBelongId(Integer.parseInt(postId));
        if (1 == goService.DeleteFavort(postFavort)){
            map.put("Data",Integer.parseInt(userId));//////////////////////
        }
        return map;
    }

    @RequestMapping("/create/comment")
    @ResponseBody
    public Map<String,Object> AddComment(@RequestParam(value = "content",required = false) String content,
                                         @RequestParam(value = "cType",required = false) String cType,
                                         @RequestParam(value = "userId",required = false) String userId,
                                            @RequestParam(value = "touserId",required = false) String touserId,
                                         @RequestParam(value = "postId",required = false) String postId){
        System.out.println(content);
        System.out.println(cType);
        System.out.println(userId);
        System.out.println(touserId);
        System.out.println(postId);
        Map map = new HashMap<String,Object>();
        map.put("Msg","success");
        map.put("Is",100);
        PostComment postComment = new PostComment();
        postComment.setUserId(Integer.parseInt(userId));
        postComment.setToReplyUserId(Integer.parseInt(touserId));
        postComment.setCtype(Integer.parseInt(cType));
        postComment.setContent(content);
        postComment.setBelongId(Integer.parseInt(postId));

        if (1 == goService.InsertPostComment(postComment)){
            PostComment com = goService.ReturnCommentLastOne();
            PostComment postComment1 = new PostComment();
            postComment1.setId(com.getId());
            postComment1.setType(com.getCtype());
            postComment1.setContent(content);
            User u = userService.findUserbyPrimaryKey(Integer.parseInt(userId));
            User touser = userService.findUserbyPrimaryKey(Integer.parseInt(touserId));
            postComment1.setUser(u);
            postComment1.setToreplyuser(touser);

            Post post = goService.FindPostbyPrimaryKey(Integer.parseInt(postId));
            postComment1.setBelong(post);
            map.put("Data",postComment1);
        }
        return map;
    }

    @RequestMapping("/delete/comment")
    @ResponseBody
    public Map<String,Object> DeleteComment(@RequestParam(value = "commentId",required = false) String commentId){
        System.out.println(commentId);
        Map map = new HashMap<String,Object>();
        map.put("Msg","success");
        map.put("Is",100);
        if (1 == goService.DeleteComment(Integer.parseInt(commentId))){
            map.put("Data",Integer.parseInt(commentId));
        }
        return map;
    }

    @RequestMapping("/delete/post")
    @ResponseBody
    public Map<String,Object> DeletePost(@RequestParam(value = "postId",required = false) String postId,
                                         @RequestParam(value = "userId",required = false) String userId){
        //TODO:用户删除说说后，只是把post表中的对应说说内容给三处了，而没有删除post_image中这个说说所携带的图片，以及post_coment表中牵扯到该说说的评论，考虑利用数据库外键关联来删除无用内容
        System.out.println(userId);
        System.out.println(postId);
        Map map = new HashMap<String,Object>();
        map.put("Msg","success");
        map.put("Is",100);
        Post post = new Post();
        post.setAuthorId(Integer.parseInt(userId));
        post.setId(Integer.parseInt(postId));

        if (1 == goService.DeletePost(post)){
            map.put("Data",null);
        }
        return map;
    }
}
