package qiqihaer.desk.www.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Filetmp implements Serializable {
    private String userId;
    private String contentText;
    private MultipartFile image1;
    private MultipartFile image2;
    private MultipartFile image3;
    private MultipartFile image4;
    private MultipartFile image5;
    private MultipartFile image6;

    public MultipartFile getImage3() {
        return image3;
    }

    public void setImage3(MultipartFile image3) {
        this.image3 = image3;
    }

    public MultipartFile getImage4() {
        return image4;
    }

    public void setImage4(MultipartFile image4) {
        this.image4 = image4;
    }

    public MultipartFile getImage5() {
        return image5;
    }

    public void setImage5(MultipartFile image5) {
        this.image5 = image5;
    }

    public MultipartFile getImage6() {
        return image6;
    }

    public void setImage6(MultipartFile image6) {
        this.image6 = image6;
    }

    public MultipartFile getImage2() {
        return image2;
    }

    public void setImage2(MultipartFile image2) {
        this.image2 = image2;
    }

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
