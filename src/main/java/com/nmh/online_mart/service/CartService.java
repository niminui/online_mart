package com.nmh.online_mart.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nmh.online_mart.model.CartItem;
import com.nmh.online_mart.model.ProductInformation;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niminui
 * @date 2020/4/25 22:47
 */
@Service
public class CartService {

    @Autowired
    private ProductionService productionService;

    public void addCart(Long id, Long count, HttpServletRequest request, HttpServletResponse response) {
        String cookieName = "cart";
        List<CartItem> list = getCartFromCookie(request,cookieName);
        boolean haveFlag = false;
        for(CartItem c : list) {
            if(c.getId().equals(id)) {
                c.setCount(c.getCount() + count);
                haveFlag = true;
                break;
            }
        }

        if(!haveFlag) {
            ProductInformation production = productionService.selectProductionById(id);
            CartItem cartItem = new CartItem();
            cartItem.setCount(count);
            cartItem.setId(id);
            cartItem.setPrice(production.getPrice());
            cartItem.setName(production.getName());
            list.add(cartItem);
        }
        CookieUtils.setCookie(request,response,cookieName, JSON.toJSONString(list),24*3600*365,true);
    }

    private List<CartItem> getCartFromCookie(HttpServletRequest request, String cookieName) {
        String json = CookieUtils.getCookieValue(request, cookieName, true);
        List<CartItem> list  = JSONArray.parseArray(json, CartItem.class);
        if(list == null || list.size() == 0) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }
}
