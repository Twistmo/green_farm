package cn.nchu.green_farm.controller;

import cn.nchu.green_farm.entity.Order;
import cn.nchu.green_farm.service.IOrderService;
import cn.nchu.green_farm.util.ResponseResult;
import cn.nchu.green_farm.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 订单控制器
 * @author Choococo
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;

    /*
     * @RequestParam("address") 和前端界面(客户端)的orderConfirm的选择地址的
     * name属性的名称相同<select>
     * @RequestParam("cart_id"):和前端界面(客户端)的orderConfirm的
     * <input type="hiden" name="cart_id" value="#{id}"/>的name属性相同
     */
    @RequestMapping("/create")
    public ResponseResult<Order> createOrder(
            HttpSession session,
            @RequestParam("address")  Integer addressId,
            @RequestParam("cart_id") Integer[] cartIds) {
        Integer uid = getUidFromSession(session);
        String username = session.getAttribute("username").toString();
        Order order = orderService.createOrder(uid, username, addressId, cartIds);
        return new ResponseResult<>(SUCCESS, order);
    }


    @GetMapping("/details/{id}")
    public ResponseResult<OrderVO> getById(@PathVariable("id") Integer id) {
        OrderVO data = orderService.getById(id);
        return new ResponseResult<>(SUCCESS, data);
    }

    @GetMapping("/detail/{ono}")
    public ResponseResult<Order> getByOno(@PathVariable("ono") Long ono) {
        Order data = orderService.getByOno(ono);
        return new ResponseResult<>(SUCCESS, data);
    }

    // 按理说使用PostMapping时，是让表单中提交的数据不可见时，用
    // GetMapping是可见的数据，@PathVariable 当用户需要在地址栏中将值传到另一个界面中使用
    // RequestParam 是当控制器层需要提交的参数过多的时候，用
    // http://localhost:8080/order/status?ono=201910181393999
//    @GetMapping("/status")
    @PostMapping("/status") // 将已经支付成功的订单数据设置为1，用于订单显示
    public ResponseResult<Void> changeStatusOfPay(HttpSession session,@RequestParam("ono") Long ono) {
        orderService.changeStatusPay(ono, getUidFromSession(session));
        return new ResponseResult<>(SUCCESS);
    }
}
