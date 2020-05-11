package com.nmh.online_mart.service;

import com.nmh.online_mart.dto.MsgDTO;
import com.nmh.online_mart.mapper.OrderFormMapper;
import com.nmh.online_mart.mapper.OrderFormMapperExt;
import com.nmh.online_mart.model.CartItem;
import com.nmh.online_mart.model.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niminui
 * @date 2020/4/27 12:26
 */
@Service
public class OrderFormService {

    @Autowired
    private OrderFormMapper orderFormMapper;

    @Autowired
    private OrderFormMapperExt orderFormMapperExt;

    public MsgDTO createOrder(List<CartItem> cartItems, Long userId, String destination) {
        try {
            StringBuilder sb = new StringBuilder("[");
            float totalPrice = 0f;
            int listSize = cartItems.size();
            for(int i = 0; i < listSize; i++) {
                CartItem cartItem = cartItems.get(i);
                totalPrice += (cartItem.getPrice() * cartItem.getCount());
                if(i == listSize - 1) {
                    sb.append("{\"id\":" + cartItem.getId() + "," + "\"name\":\"" + cartItem.getName() + "\"," + "\"price\":" + cartItem.getPrice() + "," + "\"count\":" + cartItem.getCount() + "," + "\"total\":" + cartItem.getPrice() * cartItem.getCount() + "}");
                } else {
                    sb.append("{\"id\":" + cartItem.getId() + "," + "\"name\":\"" + cartItem.getName() + "\"," + "\"price\":" + cartItem.getPrice() + "," + "\"count\":" + cartItem.getCount() + "," + "\"total\":" + cartItem.getPrice() * cartItem.getCount() + "},");
                }
            }
            sb.append("]");
            String toString = sb.toString();
            OrderForm OrderForm = new OrderForm();
            OrderForm.setUserId(userId);
            OrderForm.setProductIdArray(toString);
            OrderForm.setTotalPrice(totalPrice);
            OrderForm.setGmtCreate(System.currentTimeMillis());
            OrderForm.setDestination(destination);
            OrderForm.setStatus("未送达");
            orderFormMapper.insert(OrderForm);
        } catch (Exception e) {
            e.printStackTrace();
            return MsgDTO.fail().add("msg","创建订单失败！");
        }
        return MsgDTO.success().add("msg","支付成功！请刷新本页面！");
    }

    public List<OrderForm> selectAllOrderList() {
        return orderFormMapperExt.selectAllOrderList();
    }

    public OrderForm selectOrderByOrderId(Long orderId) {
        return orderFormMapper.selectByPrimaryKey(orderId);
    }
}
