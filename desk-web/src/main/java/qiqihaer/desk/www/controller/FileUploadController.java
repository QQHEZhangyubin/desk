package qiqihaer.desk.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import qiqihaer.desk.www.entity.Filetmp;
import qiqihaer.desk.www.entity.UserContent;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    @RequestMapping("regist")
    public String regist(HttpServletRequest request,
                         @ModelAttribute Filetmp file,
                         Model model) throws Exception, IOException{
        //TODO:将上传文件放到D盘的picture文件夹里面，得到访问该图片的虚拟路径，存到数据库里面
        //注意：从Tomcat本地文件夹下启动Tomcat
        // http://localhost:8080/ROOT/pp/a.jpg
        // http://localhost:8080/ROOT/pp/8.jpg
        // http://localhost:8080/desk_web_war/seat/queryempteyseat
        // http://localhost:8080/desk_web_war/talk/request
            if (!file.getImage1().isEmpty()){
                //文件上传路径
                String path = request.getServletContext().getRealPath("/images/");
                System.out.println(request.getServletPath());
                System.out.println(path);
                System.out.println(request.getSession().getServletContext().getRealPath("/111a/"));
                //上传文件名
                String filename = file.getImage1().getOriginalFilename();
                File filepath = new File(path, filename);
                System.out.println(filename);
                System.out.println(filepath.getAbsolutePath());
                System.out.println(filepath.getPath());
                //判断路径是否存在
                if (!filepath.getParentFile().exists()){
                    filepath.getParentFile().mkdirs();
                }
                //将上传文件保存到一个目标文件中
                file.getImage1().transferTo(new File("D:\\picture"+filename));
            }
            return "userinfo";
    }
}
