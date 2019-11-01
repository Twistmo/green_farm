package cn.nchu.green_farm.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {

    private static final long serialVersionUID = 2894164431960117519L;

    private Integer id;
    private String content;
    private Integer productId;
    private String username;
    private Date createdTime;

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
        this.content = content;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", productId=" + productId +
                ", username='" + username + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
