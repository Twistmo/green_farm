package cn.nchu.green_farm.mapper;

import cn.nchu.green_farm.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 插入评论数据
     * @param comment 评论数据
     * @return 受影响的行数
     */
    Integer addnew(Comment comment);

    List<Comment> findList();
}
