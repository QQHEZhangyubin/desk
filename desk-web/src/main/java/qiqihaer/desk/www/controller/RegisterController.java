package qiqihaer.desk.www.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.User;
import qiqihaer.desk.www.service.UserService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {
    private final static Logger log = Logger.getLogger(RegisterController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/doRegister")
    @ResponseBody
    public Map<String,Object> doRegister(Model model, @RequestParam(value = "userid",required = false) String userid,
                                         @RequestParam(value = "college",required = false) String college,
                                         @RequestParam(value = "classs",required = false) String classs,
                                         @RequestParam(value = "birthday",required = false) String birthday,
                                         @RequestParam(value = "email",required = false) String email,
                                         @RequestParam(value = "gender",required = false) String gender){
        log.debug("注册....");
        Map map = new HashMap<String,Object>();
        User user = userService.findById(userid);
        if (user!=null){
            map.put("message","existed");
        }else {
            user.setUserid(userid);
            user.setCollege(college);
            user.setClasss(classs);
            user.setBirthday(birthday);
            user.setEmail(email);
            user.setGender(gender);
            userService.regist(user);
            log.info("注册成功");
            map.put("message","success");
        }
        System.out.println(map);
        return map;
    }
}
