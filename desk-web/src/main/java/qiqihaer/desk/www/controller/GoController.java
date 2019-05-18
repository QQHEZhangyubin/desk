package qiqihaer.desk.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import qiqihaer.desk.www.entitytmp.Post;
import qiqihaer.desk.www.service.GoService;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("api/post")
public class GoController {
    @Autowired
    private GoService goService;

    @RequestMapping("/read/postlist")
    @ResponseBody
    public Map<String,Object>  GetPostList(@RequestParam(value = "pageIndex",required = false) String pageIndex,
                                           @RequestParam(value = "pageSize",required = false) String pageSize){
        Map map = new HashMap<String,Object>();
        System.out.println("pageIndex = " + pageIndex + ", pageSize = " + pageSize);
        List<Post> l = goService.QueryPost(Integer.parseInt("0"), Integer.parseInt("0"));
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
                                            @RequestParam(value = "video" ,required = false) CommonsMultipartFile video,
                                            @RequestParam(value = "videoImg" ,required = false) CommonsMultipartFile videoimg){
        Map map = new HashMap<String,Object>();
        System.out.println(content);
        System.out.println(userId);
        System.out.println(type);
        System.out.println(video.getOriginalFilename());
        System.out.println(videoimg.getOriginalFilename());
        map.put("Msg","success");
        map.put("Is",100);
        try {
            video.transferTo(new File("E:\\picture",video.getOriginalFilename()));
            videoimg.transferTo(new File("E:\\picture",videoimg.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Post post = new Post();
        post.setAuthorId(Integer.parseInt(userId));
        post.setCreateTime(new Date()+"");
        post.setContent(content);
        post.setVideoUrl(FileUploadController.baseUrl + video.getOriginalFilename());
        post.setVideoImgUrl(FileUploadController.baseUrl + videoimg.getOriginalFilename());
        post.setType(Integer.parseInt(type));
        if (1 == goService.InsertVideoPost(post)){
            Post post1 = new Post();
            post1.setContent(content);
            post.setVideoUrl(FileUploadController.baseUrl + video.getOriginalFilename());
            post.setVideoImgUrl(FileUploadController.baseUrl + videoimg.getOriginalFilename());
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
                                           @RequestParam(value = "haveimg",required = false) String having,
                                           @RequestParam(value = "photos",required = false) CommonsMultipartFile []commonsMultipartFiles){

        System.out.println(content);
        System.out.println(userId);
        System.out.println(type);
        System.out.println(having);
        List<String> images = new ArrayList<>();
        Map map = new HashMap<String,Object>();
        map.put("Msg","success");
        map.put("Is",100);
        if (having.equals("have")){
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
        }else {
            Post post = new Post();
            post.setContent(content);
            post.setAuthorId(Integer.parseInt(userId));
            post.setType(Integer.parseInt(type));
            if (1 == goService.InsertVideoPost(post)){
                Post pl = goService.QueryNoImagePost(post);
                map.put("Data",pl);
            }
        }

        return map;
    }

}
