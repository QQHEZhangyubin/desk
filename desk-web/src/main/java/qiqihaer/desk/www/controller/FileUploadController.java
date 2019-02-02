package qiqihaer.desk.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import qiqihaer.desk.www.entity.Filetmp;
import qiqihaer.desk.www.entity.UserContent;
import qiqihaer.desk.www.service.UserContentService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Controller
@RequestMapping("/imgs")
public class FileUploadController {
    @Autowired
    private UserContentService userContentService;
    private static final String baseUrl = "http://localhost:8080/ROOT/pp/";
    private UserContent userContent;

    /**
     * pc端上传，服务端接受
     * @param request
     * @param file
     * @param model
     * @return
     * @throws Exception
     * @throws IOException
     */
    @RequestMapping("regist")
    @ResponseBody
    public HashMap<String,Object> regist(HttpServletRequest request,
                          @ModelAttribute Filetmp file,
                          Model model) throws Exception, IOException{
        //TODO:将上传文件放到D盘的picture文件夹里面，得到访问该图片的虚拟路径，存到数据库里面
        //注意：从Tomcat本地文件夹下启动Tomcat
        // http://localhost:8080/ROOT/pp/a.jpg
        // http://localhost:8080/ROOT/pp/8.jpg
        // http://localhost:8080/desk_web_war/seat/queryempteyseat
        // http://localhost:8080/desk_web_war/talk/request
        HashMap<String, Object> map = new HashMap<>();
        String userId = file.getUserId();
        String contexttext = file.getContentText();
        userContent = new UserContent();
        userContent.setUserId(userId);
        userContent.setContentText(contexttext);
        userContent.setContentDate(new Date());
        userContent.setContentBrower(new Random(1).nextInt(100));
        //http://localhost:8080/ROOT/pp/201919.jpg
        if (!file.getImage1().isEmpty()){
                //上传文件名
                String filename = file.getImage1().getOriginalFilename();
                //System.out.println(filename);
                //将上传文件保存到一个目标文件中
                file.getImage1().transferTo(new File("D:\\picture",filename));
                System.out.println(baseUrl+filename);
                userContent.setContentImg1(baseUrl+filename);
        }
        if (!file.getImage2().isEmpty()){
                String filename = file.getImage2().getOriginalFilename();
                System.out.println(filename);
                file.getImage2().transferTo(new File("D:\\picture",filename));
                userContent.setContentImg2(baseUrl+filename);
        }
        if (!file.getImage3().isEmpty()){
            String filename = file.getImage3().getOriginalFilename();
            System.out.println(filename);
            file.getImage3().transferTo(new File("D:\\picture",filename));
            userContent.setContentImg3(baseUrl+filename);
        }
        if (!file.getImage4().isEmpty()){
            String filename = file.getImage4().getOriginalFilename();
            System.out.println(filename);
            file.getImage4().transferTo(new File("D:\\picture",filename));
            userContent.setContentImg4(baseUrl+filename);
        }
        if (!file.getImage5().isEmpty()){
            String filename = file.getImage5().getOriginalFilename();
            System.out.println(filename);
            file.getImage5().transferTo(new File("D:\\picture",filename));
            userContent.setContentImg5(baseUrl+filename);
        }
        if (!file.getImage6().isEmpty()){
            String filename = file.getImage6().getOriginalFilename();
            System.out.println(filename);
            file.getImage6().transferTo(new File("D:\\picture",filename));
            userContent.setContentImg6(baseUrl+filename);
        }
        userContentService.AddShuoShuo(userContent);
        map.put("status",2);
        map.put("data",userContent);
        return map;
    }

    /**
     * 移动端上传，服务端接受
     * @param multipartFiles
     * @param data
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String imageUpload(@RequestParam("file") MultipartFile[] multipartFiles,
                              String data){
        userContent = new UserContent();
        userContent.setUserId("2016021051");
        userContent.setContentText(data);
        userContent.setContentDate(new Date());
        userContent.setContentBrower(new Random(1).nextInt(100));
        try{
            System.out.println(data);
            if (multipartFiles != null && multipartFiles.length > 0){
                for (int i = 0; i <multipartFiles.length ; i++) {
                    MultipartFile partFile = multipartFiles[i];
                    partFile.transferTo(new File("D:\\picture",partFile.getOriginalFilename()));
                    if (i == 0){
                        userContent.setContentImg1(baseUrl+partFile.getOriginalFilename());
                    }
                    if (i == 1){
                        userContent.setContentImg2(baseUrl+partFile.getOriginalFilename());
                    }
                    if (i == 2){
                        userContent.setContentImg3(baseUrl+partFile.getOriginalFilename());
                    }
                    if (i == 3){
                        userContent.setContentImg4(baseUrl+partFile.getOriginalFilename());
                    }
                    if (i == 4){
                        userContent.setContentImg5(baseUrl+partFile.getOriginalFilename());
                    }
                    if (i == 5){
                        userContent.setContentImg6(baseUrl+partFile.getOriginalFilename());
                    }
                }
                userContentService.AddShuoShuo(userContent);
                return "{\"status\":0,\"desc\":\"成功\"}";
            }
        }catch (Exception e){
           e.printStackTrace();
        }
        return "{\"status\":-1,\"desc\":\"失败\"}";
    }
}
