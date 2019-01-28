package qiqihaer.desk.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.TestEntity;
import qiqihaer.desk.www.entity.UserContent;
import qiqihaer.desk.www.service.UserContentService;

import java.util.*;

@Controller
@RequestMapping("/talk")
public class TalkController {
    @Autowired
    private UserContentService userContentService;
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
        userContent.setUserId("2016021052");
        userContent.setContentBrower(130);
        userContent.setContentText("fckgh;guoliuhiougihiib");
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
            bean.setBrowser(e.getContentBrower()+"");
            bean.setPicture(e.getContentImg1());
            bean.setTime(e.getContentDate()+"");
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


}
