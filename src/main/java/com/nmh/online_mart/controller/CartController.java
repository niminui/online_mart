package com.nmh.online_mart.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nmh.online_mart.mapper.ProductInformationMapper;
import com.nmh.online_mart.model.CartItem;
import com.nmh.online_mart.model.ProductInformation;
import com.nmh.online_mart.service.CartService;
import com.nmh.online_mart.service.ProductionService;
import com.nmh.online_mart.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author niminui
 * @date 2020/4/25 21:13
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/addToCartWithProduction/{id}")
    public String addToCartWithProduction(@PathVariable("id")Long id,
                                          @RequestParam(value = "count",defaultValue = "1")Long count,
                                          HttpServletRequest request, HttpServletResponse response) {
        cartService.addCart(id,count,request,response);
        return "redirect:/index";
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

}
