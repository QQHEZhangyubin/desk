package qiqihaer.desk.www.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.Comment;
import qiqihaer.desk.www.entity.Reply;
import qiqihaer.desk.www.service.CommentAndReplyService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/comreply")
public class CommantAndReplyController {
    @Autowired
    private CommentAndReplyService commentAndReplyService;
    @RequestMapping("/comment")
    @ResponseBody
    public Map<String,Object> insertcomment(Model model,
                                            @RequestParam(value = "userid",required = false) String userid,
                                            @RequestParam(value = "iduser_content",required = false) String iduser_content,
                                            @RequestParam(value = "content",required = false) String content){
        Map<String,Object> map = new HashMap<>();
        Comment comment = new Comment();
        comment.setuId(userid);
        comment.setContent(content);
        comment.setCreateDate(new Date());
        comment.setComId(Long.valueOf(iduser_content));
        int flag = commentAndReplyService.Insert_One_Comment(comment);
        if (flag == 1){
            //插入评论成功
            map.put("comment",2);
        }else {
            //插入评论失败
            map.put("comment",3);
        }
        return map;
    }

    @RequestMapping("/reply")
    @ResponseBody
    public Map<String,Object> insertreply(Model model,
                                          @RequestParam(value = "userid",required = false) String userid,
                                          @RequestParam(value = "replyComId",required = false) String replyComId,
                                          @RequestParam(value = "replyContent",required = false) String replyContent){
        Map<String,Object> map = new HashMap<>();
        Reply reply = new Reply();
        reply.setReplyUId(userid);
        reply.setReplyDate(new Date());
        reply.setReplyContent(replyContent);
        reply.setReplyComId(Integer.valueOf(replyComId));
        int flag = commentAndReplyService.Inssert_One_Reply(reply);
        if (flag == 1){
            //评论成功
            map.put("reply",11);
        }else {
            //评论失败
            map.put("reply",12);
        }
        return map;
    }


}
