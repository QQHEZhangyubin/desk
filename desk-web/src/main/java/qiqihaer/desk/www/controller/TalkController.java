package qiqihaer.desk.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.*;
import qiqihaer.desk.www.entitytmp.CommentBean;
import qiqihaer.desk.www.entitytmp.CommentDetailBean;
import qiqihaer.desk.www.entitytmp.ReplyDetailBean;
import qiqihaer.desk.www.service.UserContentService;
import qiqihaer.desk.www.service.UserService;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/talk")
public class TalkController {
    @Autowired
    private UserContentService userContentService;
    @Autowired
    private UserService userService;
    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> AddShuoShuo(Model model,
                                  @RequestParam(value = "userId",required = false) String userId,
                                  @RequestParam(value = "contentText",required = false) String contentText,
                                  @RequestParam(value = "contentImg1",required = false) String contentImg1,
                                  @RequestParam(value = "contentImg2",required = false) String contentImg2,
                                  @RequestParam(value = "contentImg3",required = false) String contentImg3,
                                  @RequestParam(value = "contentImg4",required = false) String contentImg4,
                                  @RequestParam(value = "contentImg5",required = false) String contentImg5,
                                  @RequestParam(value = "contentImg6",required = false) String contentImg6,
                                  @RequestParam(value = "contentBrower",required = false) Integer contentBrower,
                                  @RequestParam(value = "contentDate",required = false) Date contentDate){
        Map map = new HashMap<String,Object>();
        UserContent userContent = new UserContent();
        userContent.setUserId(userId);
        userContent.setContentText(contentText);
        userContent.setContentDate(new Date());
        userContent.setContentImg1(contentImg1);
        userContent.setContentImg2(contentImg2);
        userContent.setContentImg3(contentImg3);
        userContent.setContentImg4(contentImg4);
        userContent.setContentImg5(contentImg5);
        userContent.setContentImg6(contentImg6);
        int result = userContentService.AddShuoShuo(userContent);
        if (result == 1){
            System.out.println("插入说说成功！");
            map.put("status",1);
        }else {
            System.out.println("插入说说失败！");
            map.put("status",0);
        }
        return map;
    }

    @RequestMapping("/request")
    @ResponseBody
    public List<TestEntity.BodyBean.EListBean> findAll(Model model){
        List<UserContent> elist = userContentService.PullDownAll();
        List<TestEntity.BodyBean.EListBean> mDatas = new ArrayList();
        for (UserContent e:elist) {
            TestEntity.BodyBean.EListBean bean = new TestEntity.BodyBean.EListBean();
            List<String> urls = new ArrayList<>();
            bean.setBrowser(e.getIduserContent()+"");//设置说说的id标识

            //设置发说说人的头像
            String userid = e.getUserId();
            User u1 = userService.findById(userid);
            bean.setPicture(u1.getUserlogo());

            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            bean.setTime(e.getContentDate()+"");//时间需要转变格式
            //formatter.format(e.getContentDate());

            bean.setContent(e.getContentText());
            bean.setUserName(e.getUserId());
            if (e.getContentImg1() != null){
                urls.add(e.getContentImg1());
            }
            if (e.getContentImg2() != null){
                urls.add(e.getContentImg2());
            }
            if (e.getContentImg3() != null){
                urls.add(e.getContentImg3());
            }
            if (e.getContentImg4() != null){
                urls.add(e.getContentImg4());
            }
            if (e.getContentImg5() != null){
                urls.add(e.getContentImg5());
            }
            if (e.getContentImg6() != null){
                urls.add(e.getContentImg6());
            }

            bean.setEPicture(urls);
            mDatas.add(bean);
        }
        return  mDatas;
    }

    //得到该说说的全部评论，以及每个评论的字评论
    @RequestMapping("/request2")
    @ResponseBody
    public CommentBean Request2(Model model,
                                @RequestParam(value = "iduser_content",required = false) String iduser_content){

        System.out.println("请求的说说标识："+iduser_content);
        CommentBean commentBean = new CommentBean();
        UserContent userContent = new UserContent();
        //iduser_content = Long.valueOf(10);//该说说的唯一标示
        userContent.setIduserContent(Long.valueOf(iduser_content));
        commentBean.setCode(200);
        List<Comment> comments = userContentService.PullThis(userContent);
        if (comments != null && comments.size() > 0){
            List<CommentDetailBean> co = new ArrayList<>();
            for (Comment c: comments){
                List<ReplyDetailBean> lo = new ArrayList<>();
                User C_user = userService.findById(c.getuId());//得到评论该说说的用户
                CommentDetailBean commentDetailBean = new CommentDetailBean(C_user.getUserid(),c.getContent(),c.getCreateDate()+"");
                commentDetailBean.setUserLogo(C_user.getUserlogo());
                commentDetailBean.setImId("imid");
                commentDetailBean.setId(c.getCommentId());
                List<Reply> replies = userContentService.PullThese(c);
                if (replies != null && replies.size() > 0){
                    for (Reply r : replies){
                        User R_user = userService.findById(r.getReplyUId());//得到回复该评论的用户
                        ReplyDetailBean replyDetailBean = new ReplyDetailBean(R_user.getUserid(),r.getReplyContent());
                        replyDetailBean.setCreateDate(r.getReplyDate()+"");
                        replyDetailBean.setStatus("200");
                        replyDetailBean.setId(r.getReplyId());
                        replyDetailBean.setUserLogo(R_user.getUserlogo());
                        replyDetailBean.setCommentId(r.getReplyComId()+"");
                        lo.add(replyDetailBean);
                    }
                }
                commentDetailBean.setReplyToal(replies.size());
                commentDetailBean.setReplyDetailBeans(lo);
                co.add(commentDetailBean);
            }
            CommentBean.Data d = new CommentBean.Data();
            d.setList(co);
            d.setTotal(co.size());
            commentBean.setData(d);
            commentBean.setMessage("success");
        }else {
            System.out.println("该说说没有评论！");
        }
        return commentBean;
    }


}
