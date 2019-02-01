package qiqihaer.desk.www.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Filetmp implements Serializable {
    private String userId;
    private String contentText;
    private MultipartFile image1;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public MultipartFile getImage1() {
        return image1;
    }

    public void setImage1(MultipartFile image1) {
        this.image1 = image1;
    }
}
