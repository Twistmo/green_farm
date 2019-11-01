package cn.nchu.green_farm.service;

import cn.nchu.green_farm.entity.Order;
import cn.nchu.green_farm.service.exception.AccessDefinedException;
import cn.nchu.green_farm.service.exception.OrderDataNotFoundException;
import cn.nchu.green_farm.service.exception.ServiceException;
import cn.nchu.green_farm.service.exception.UpdateException;
import cn.nchu.green_farm.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Choococo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSerivceTestCase {

    @Resource
    private IOrderService orderService;

    @Test
    public void createOrder() {
        try {
            Integer uid =1;
            String username = "小刘老师";
            Integer addressId = 5;
            Integer[] cartIds = {7,8};
            Order order = orderService.createOrder(uid, username, addressId, cartIds);

            System.err.println("order="+ order);
        } catch (ServiceException e) {
            System.err.println("错误类型:" + e.getClass().getName());
            System.err.println("错误描述:" + e.getMessage());
        }
    }

    @Test
    public void getById() {
        try {
            Integer id = 8;
            OrderVO orderVO = orderService.getById(id);
            System.err.println(orderVO);
        } catch (ServiceException e) {
            System.err.println("错误类型:" +  e.getClass().getName());
            System.err.println("错误描述:" +  e.getMessage());
        }
    }

    @Test
    public void changeStatusPay() {
        try {
            Long ono = 201910187790999L;
            Integer uid = 2;
            orderService.changeStatusPay(ono,uid);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println("错误类型:" +  e.getClass().getName());
            System.err.println("错误描述:" +  e.getMessage());
        }
    }
}
