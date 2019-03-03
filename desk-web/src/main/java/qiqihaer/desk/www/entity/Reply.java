package qiqihaer.desk.www.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer replyId;

    private Integer replyComId;

    private String replyUId;

    private Date replyDate;

    private String replyContent;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyComId() {
        return replyComId;
    }

    public void setReplyComId(Integer replyComId) {
        this.replyComId = replyComId;
    }

    public String getReplyUId() {
        return replyUId;
    }

    public void setReplyUId(String replyUId) {
        this.replyUId = replyUId == null ? null : replyUId.trim();
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}