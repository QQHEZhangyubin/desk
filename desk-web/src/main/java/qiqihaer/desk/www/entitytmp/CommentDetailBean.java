package qiqihaer.desk.www.entitytmp;

import java.util.List;

public class CommentDetailBean {
    private int id;
    private String nickName;
    private String userLogo;
    private String content;
    private String imId;
    private int replyToal;
    private String createDate;
    private List<ReplyDetailBean> replyDetailBeans;

    public CommentDetailBean(String nickName, String content, String createDate) {
        this.nickName = nickName;
        this.content = content;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public int getReplyToal() {
        return replyToal;
    }

    public void setReplyToal(int replyToal) {
        this.replyToal = replyToal;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<ReplyDetailBean> getReplyDetailBeans() {
        return replyDetailBeans;
    }

    public void setReplyDetailBeans(List<ReplyDetailBean> replyDetailBeans) {
        this.replyDetailBeans = replyDetailBeans;
    }
}
