package com.nmh.online_mart.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nmh.online_mart.dto.MsgDTO;
import com.nmh.online_mart.model.CartItem;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.service.CartService;
import com.nmh.online_mart.service.OrderFormService;
import com.nmh.online_mart.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niminui
 * @date 2020/4/25 21:13
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderFormService orderFormService;

    @RequestMapping("/addToCartWithProduction/{id}")
    public String addToCartWithProduction(@PathVariable("id")Long id,@RequestParam("page")String page,
                                          @RequestParam(value = "count",defaultValue = "1")Long count,
                                          HttpServletRequest request, HttpServletResponse response) {
        cartService.addCart(id,count,request,response);
        return "redirect:/" + page;
    }

    @RequestMapping(value = "/cartTransferStation", method = RequestMethod.POST)
    @ResponseBody
    public List<CartItem> cartTransferStation(@RequestBody String data) {
        String decode = "";
        try {
            decode = URLDecoder.decode(data, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }
        String json = decode.substring(0, decode.length() - 1);

        return JSONObject.parseArray(json, CartItem.class);
    }

    @RequestMapping(value = "/deleteProductionByCart/{id}")
    public String deleteProductionByCart(@PathVariable("id")Long id, @RequestParam("page")String page,
                                         HttpServletRequest request, HttpServletResponse response){
        String cart = CookieUtils.getCookieValue(request, "cart", true);
        List<CartItem> cartItems = JSONObject.parseArray(cart, CartItem.class);
        for(CartItem cartItem : cartItems) {
            if(cartItem.getId().equals(id)) {
                cartItems.remove(cartItem);
                break;
            }
        }
        CookieUtils.setCookie(request,response,"cart", JSON.toJSONString(cartItems),24*3600*365,true);
        return "redirect:/"+page;
    }

    @RequestMapping(value = "/paymentByCart", method = RequestMethod.POST)
    @ResponseBody
    public MsgDTO paymentByCart(HttpServletRequest request, HttpServletResponse response) {
        String cart = CookieUtils.getCookieValue(request, "cart", true);
        User user = (User) request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(cart)) {
            return MsgDTO.fail().add("msg","您还没有添加添加任何商品！");
        }
        List<CartItem> cartItems = JSONObject.parseArray(cart, CartItem.class);
        MsgDTO msgDTO = orderFormService.createOrder(cartItems, user.getId(), user.getAddress());

        if(msgDTO.getCode() == 100) {
            ArrayList<CartItem> NullCartItems = new ArrayList<>();
            NullCartItems.add(new CartItem());
            msgDTO.add("NullCartItems", NullCartItems);
            CookieUtils.setCookie(request,response,"cart","",24*3600*365);
        }
        return msgDTO;
    }

}
