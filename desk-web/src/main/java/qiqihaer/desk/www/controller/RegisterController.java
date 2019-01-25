package qiqihaer.desk.www.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.common.MD5Util;
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
                                         @RequestParam(value = "password",required = false) String password,
                                         @RequestParam(value = "classs",required = false) String classs,
                                         @RequestParam(value = "birthday",required = false) String birthday,
                                         @RequestParam(value = "email",required = false) String email,
                                         @RequestParam(value = "gender",required = false) String gender){
        log.debug("注册....");
        Map map = new HashMap<String,Object>();
        User user = userService.findById("2016021053");
        if (user!=null){
            map.put("message","existed");
        }else {
            User user1 = new User();
            user1.setUserid("2016021053");
            user1.setCollege("计算机与控制工程学院");
            user1.setClasss("软件161");
            user1.setPassword(MD5Util.encodeToHex("11zhangyubin"));
            user1.setBirthday("1998/10/23");
            user1.setEmail("13608428279@163.com");
            user1.setGender("男");
            userService.regist(user1);
            log.info("注册成功");
            map.put("message","success");
        }
        System.out.println(map);
        return map;
    }
}
