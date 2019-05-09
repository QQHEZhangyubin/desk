package qiqihaer.desk.www.entitytmp;

import javax.persistence.*;

@Table(name = "post_image")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private String size;

    private String name;

    private Integer belongId;
    @Transient
    private Post belong;

    public Post getBelong() {
        return belong;
    }

    public void setBelong(Post belong) {
        this.belong = belong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getBelongId() {
        return belongId;
    }

    public void setBelongId(Integer belongId) {
        this.belongId = belongId;
    }
}