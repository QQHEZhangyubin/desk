package qiqihaer.desk.www.entitytmp;


import qiqihaer.desk.www.entity.User;

import javax.persistence.*;
import java.util.List;

@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private String createTime;

    private Integer type;

    private String linkImg;

    private String linkTitle;

    private Integer authorId;

    private String videoUrl;

    private String videoImgUrl;


    private String linkUrl;

    private String linkDesc;

    @Transient
    private User author;
    @Transient
    private List<PostImage> postImages;
    @Transient
    private List<PostComment> postComments;
    @Transient
    private List<PostFavort> postFavorts;

    public User getAuthor() {
        return author;
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public List<PostComment> getPostComments() {
        return postComments;
    }

    public List<PostFavort> getPostFavorts() {
        return postFavorts;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }



    public void setPostComments(List<PostComment> postComments) {
        this.postComments = postComments;
    }



    public void setPostFavorts(List<PostFavort> postFavorts) {
        this.postFavorts = postFavorts;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkDesc() {
        return linkDesc;
    }

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }


    public void setAuthor(User author) {
        this.author = author;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg == null ? null : linkImg.trim();
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle == null ? null : linkTitle.trim();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoImgUrl() {
        return videoImgUrl;
    }

    public void setVideoImgUrl(String videoImgUrl) {
        this.videoImgUrl = videoImgUrl == null ? null : videoImgUrl.trim();
    }
}