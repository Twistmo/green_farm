package cn.nchu.green_farm.service;

import cn.nchu.green_farm.entity.Comment;

import java.util.List;

public interface ICommentService {
    /**
     * 评论发布
     * @param comment 评论信息
     */
    void reg(Comment comment);

    List<Comment> getList();
}
