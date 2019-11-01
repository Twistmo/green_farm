package cn.nchu.green_farm.service;

import cn.nchu.green_farm.entity.Order;
import cn.nchu.green_farm.service.exception.AccessDefinedException;
import cn.nchu.green_farm.service.exception.InsertException;
import cn.nchu.green_farm.service.exception.OrderDataNotFoundException;
import cn.nchu.green_farm.service.exception.UpdateException;
import cn.nchu.green_farm.vo.OrderVO;

/**
 * 订单与订单商品的业务层接口
 */
public interface IOrderService {

    /**
     * 创建订单
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户的用户名
     * @param addressId 所选择的收获地址的id
     * @param cartIds 订单中的商品在购物车中的数据id
     * @return 成功创建订单
     */
    Order createOrder(
            Integer uid,String username,
            Integer addressId,Integer[] cartIds) throws InsertException;

    /**
     * 根据id查询订单详情
     * @param id 订单id
     * @return 匹配的订单详情，如果没有匹配的数据，则返回null
     */
    OrderVO getById(Integer id);

    /**
     * 根据订单号查询订单数据
     * @param ono 订单号
     * @return 匹配的订单数据，如果没有则返回null
     */
    Order getByOno(Long ono);

    /**
     * 在支付成功之后，根据订单号，将status该为1，已支付
     * @param ono 订单号
     * @param uid 用户id，用于判断数据归属
     */
    void changeStatusPay(Long ono, Integer uid) throws UpdateException, OrderDataNotFoundException, AccessDefinedException;
}
