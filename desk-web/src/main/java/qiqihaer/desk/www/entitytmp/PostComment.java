package qiqihaer.desk.www.entitytmp;

import qiqihaer.desk.www.entity.User;

import javax.persistence.*;

@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer toReplyUserId;

    private String content;

    private Integer belongId;

    @Transient
    private int type;
    @Transient
    private User user;
    @Transient
    private User toreplyuser;
    @Transient
    private Post belong;

    public User getUser() {
        return user;
    }

    public User getToreplyuser() {
        return toreplyuser;
    }

    public Post getBelong() {
        return belong;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public void setToreplyuser(User toreplyuser) {
        this.toreplyuser = toreplyuser;
    }



    public void setBelong(Post belong) {
        this.belong = belong;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getToReplyUserId() {
        return toReplyUserId;
    }

    public void setToReplyUserId(Integer toReplyUserId) {
        this.toReplyUserId = toReplyUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getBelongId() {
        return belongId;
    }

    public void setBelongId(Integer belongId) {
        this.belongId = belongId;
    }
}