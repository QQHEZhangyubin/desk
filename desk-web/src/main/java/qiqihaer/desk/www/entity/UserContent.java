package qiqihaer.desk.www.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class UserContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduserContent;

    private String userId;

    private String contentText;

    private String contentImg1;

    private String contentImg2;

    private String contentImg3;

    private String contentImg4;

    private String contentImg5;

    private String contentImg6;

    private Date contentDate;

    private Integer contentBrower;

    public Long getIduserContent() {
        return iduserContent;
    }

    public void setIduserContent(Long iduserContent) {
        this.iduserContent = iduserContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ? null : contentText.trim();
    }

    public String getContentImg1() {
        return contentImg1;
    }

    public void setContentImg1(String contentImg1) {
        this.contentImg1 = contentImg1 == null ? null : contentImg1.trim();
    }

    public String getContentImg2() {
        return contentImg2;
    }

    public void setContentImg2(String contentImg2) {
        this.contentImg2 = contentImg2 == null ? null : contentImg2.trim();
    }

    public String getContentImg3() {
        return contentImg3;
    }

    public void setContentImg3(String contentImg3) {
        this.contentImg3 = contentImg3 == null ? null : contentImg3.trim();
    }

    public String getContentImg4() {
        return contentImg4;
    }

    public void setContentImg4(String contentImg4) {
        this.contentImg4 = contentImg4 == null ? null : contentImg4.trim();
    }

    public String getContentImg5() {
        return contentImg5;
    }

    public void setContentImg5(String contentImg5) {
        this.contentImg5 = contentImg5 == null ? null : contentImg5.trim();
    }

    public String getContentImg6() {
        return contentImg6;
    }

    public void setContentImg6(String contentImg6) {
        this.contentImg6 = contentImg6 == null ? null : contentImg6.trim();
    }

    public Date getContentDate() {
        return contentDate;
    }

    public void setContentDate(Date contentDate) {
        this.contentDate = contentDate;
    }

    public Integer getContentBrower() {
        return contentBrower;
    }

    public void setContentBrower(Integer contentBrower) {
        this.contentBrower = contentBrower;
    }
}