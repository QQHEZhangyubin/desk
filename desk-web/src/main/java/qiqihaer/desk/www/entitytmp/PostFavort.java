package qiqihaer.desk.www.entitytmp;

import qiqihaer.desk.www.entity.User;

import javax.persistence.*;
import java.util.List;

@Table(name = "post_favort")
public class PostFavort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer belongId;

    @Transient
    private User user;

    @Transient
    private Post belong;


    public User getUser() {
        return user;
    }

    public Post getBelong() {
        return belong;
    }

    public void setBelong(Post belong) {
        this.belong = belong;
    }



    public void setUser(User user) {
        this.user = user;
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

    public Integer getBelongId() {
        return belongId;
    }

    public void setBelongId(Integer belongId) {
        this.belongId = belongId;
    }
}