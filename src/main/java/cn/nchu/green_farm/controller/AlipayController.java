package cn.nchu.green_farm.controller;

import cn.nchu.green_farm.config.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Choococo
 */
@Controller
@RequestMapping("/pay")
public class AlipayController {

    @PostMapping("/order_test")
    public void applyTest(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam("WIDout_trade_no") String WIDout_trade_no,
                          @RequestParam("WIDtotal_amount")  String WIDtotal_amount,
                          @RequestParam("WIDsubject")  String WIDsubject,
                          @RequestParam("WIDbody")  String WIDbody) throws IOException, AlipayApiException {
        //获得初始化的AlipayClient
        PrintWriter out = response.getWriter();
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        HttpSession session = request.getSession();

//        String tmoney = "";
//        String val = "";
//        String ddh = (int) ((Math.random() * 99999) + 100000) + "";
//        System.out.println(tmoney + "这是跳转的" + val + "ddh" + ddh);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = WIDout_trade_no;
        //付款金额，必填
        String total_amount = WIDtotal_amount;
        //订单名称，必填
        String subject = WIDsubject;
        //商品描述，可空
        String body = WIDbody;
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
//        String timeout_express = "5m";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
//                + "\"timeout_express\":\""+timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
        String url = alipayClient.pageExecute(alipayRequest, "get").getBody();
        System.out.println(url);
        //输出

//        request.setAttribute("result",result);
//        response.setContentType("text/html;charset=utf-8");
//        out.print(doc.outerHtml());
//      return result;
        out.print(url);
    }

    // 根据订单号查询订单数据

}
