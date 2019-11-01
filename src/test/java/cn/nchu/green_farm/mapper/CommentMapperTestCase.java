package cn.nchu.green_farm.mapper;

import cn.nchu.green_farm.entity.Cart;
import cn.nchu.green_farm.entity.Comment;
import cn.nchu.green_farm.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Choococo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTestCase {

    @Resource
    private CommentMapper commentMapper;

    @Test // 增加收货地址数据【测试成功】
    public void addnew() {
        Comment comment = new Comment();
        comment.setContent("大家好");
        Integer rows = commentMapper.addnew(comment);
        System.err.println("rows=" + rows);
    }



}
