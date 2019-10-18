package cn.nchu.green_farm.entity;

import cn.nchu.green_farm.controller.BaseController;

public class Comment extends BaseController {
    private Integer id;
    private String content;
    private Integer product_id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return content;
    }

    public void setComment(String comment) {
        this.content = comment;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", product_id=" + product_id +
                ", username='" + username + '\'' +
                '}';
    }
}
