package qiqihaer.desk.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entitytmp.Post;
import qiqihaer.desk.www.service.GoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/post")
public class GoController {
    @Autowired
    private GoService goService;

    @RequestMapping("/read/postlist")
    @ResponseBody
    public Map<String,Object>  GetPostList(@RequestParam(value = "pageIndex",required = false) String pageIndex,
                                           @RequestParam(value = "pageSize" ,required = false) String pageSize){
        Map map = new HashMap<String,Object>();
        List<Post> l = goService.QueryPost(Integer.parseInt("0"), Integer.parseInt("0"));
        //得到post集合
        map.put("Msg","success");
        map.put("Is",100);
        map.put("Data",l);
        return map;
    }
}
