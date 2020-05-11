package com.nmh.online_mart.controller;

import com.alibaba.fastjson.JSONArray;
import com.nmh.online_mart.dto.MsgDTO;
import com.nmh.online_mart.dto.OrderDetailDTO;
import com.nmh.online_mart.dto.OrderJsonDTO;
import com.nmh.online_mart.model.OrderForm;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author niminui
 * @date 2020/4/27 16:05
 */
@Controller
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;

    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    @ResponseBody
    public MsgDTO getOrderList() {
        List<OrderForm> orderForms = orderFormService.selectAllOrderList();
        if(orderForms == null || orderForms.size() == 0) {
            return MsgDTO.fail().add("msg","没有查询到相关订单！");
        }
        return MsgDTO.success().add("orderForms",orderForms);
    }

    @GetMapping("/getOrderInfo/{orderId}")
    public String getOrderInfo(@PathVariable("orderId")Long orderId, Model model) {
        OrderForm orderForm = orderFormService.selectOrderByOrderId(orderId);
        List<OrderJsonDTO> ordersDTOS = JSONArray.parseArray(orderForm.getProductIdArray(), OrderJsonDTO.class);

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setTotalPrice(orderForm.getTotalPrice());
        orderDetailDTO.setDestination(orderForm.getDestination());
        orderDetailDTO.setStatus(orderForm.getStatus());
        orderDetailDTO.setGmtCreate(orderForm.getGmtCreate());
        orderDetailDTO.setProductionList(ordersDTOS);

        model.addAttribute("orderDetailDTO",orderDetailDTO);
        return "orderDetails";
    }

}
