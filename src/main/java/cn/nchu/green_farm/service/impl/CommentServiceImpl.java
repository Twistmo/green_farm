package cn.nchu.green_farm.service.impl;

import cn.nchu.green_farm.entity.Comment;
import cn.nchu.green_farm.mapper.CommentMapper;
import cn.nchu.green_farm.service.ICommentService;
import cn.nchu.green_farm.service.exception.InsertException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;
    @Override
    public void reg(Comment comment) throws InsertException {
        Integer rows = commentMapper.addnew(comment);
        if (rows != 1) {
            throw new InsertException("新增评论数据时未知错误!");
        }
    }

    @Override
    public List<Comment> getList() {
        return commentMapper.findList();
    }
}
