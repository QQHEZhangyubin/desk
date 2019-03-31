package qiqihaer.desk.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.Soft2;
import qiqihaer.desk.www.service.SoftService;

@Controller
public class SoftController {
    @Autowired
    private SoftService softService;

    @RequestMapping("/softupdate")
    @ResponseBody
    public Soft2 getNewSoftMessage(){
        Soft2 soft = softService.UpdateSoftWare();
        return soft;
    }
}
