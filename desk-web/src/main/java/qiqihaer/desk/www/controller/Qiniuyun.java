package qiqihaer.desk.www.controller;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Qiniuyun {
    /**
     * 获取上传图片的token
     * @return
     */
    @RequestMapping("/token")
    @ResponseBody
    public Map<String,Object> getToken(){
        String accessKey = "sd0-FGKep-WKyorTHSuec9ozkuPYzsa7FRa2A1A8";
        String secretKey = "Scd_lF2pbuw_jxgcZAvSVy6S3tzx5i00DHhxuCWX";
        String bucket = "images";
        HashMap<String, Object> map = new HashMap<>();
        Auth auth = Auth.create(accessKey,secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        map.put("uptoken",upToken);
        return map;
    }

    /**
     * 获取上传视频的token
     * @return
     */
    @RequestMapping("/tokenvideo")
    @ResponseBody
    public Map<String,Object> getTokenVideo(){
        String accessKey = "sd0-FGKep-WKyorTHSuec9ozkuPYzsa7FRa2A1A8";
        String secretKey = "Scd_lF2pbuw_jxgcZAvSVy6S3tzx5i00DHhxuCWX";
        String bucket = "videos";
        HashMap<String, Object> map = new HashMap<>();
        Auth auth = Auth.create(accessKey,secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        map.put("uptoken",upToken);
        return map;
    }
}
