package qiqihaer.desk.www.entitytmp;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Filetmp2 implements Serializable {
    private String userid;
    private MultipartFile touxiangimg;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public MultipartFile getTouxiangimg() {
        return touxiangimg;
    }

    public void setTouxiangimg(MultipartFile touxiangimg) {
        this.touxiangimg = touxiangimg;
    }
}
