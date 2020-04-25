package com.nmh.online_mart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author niminui
 * @date 2020/4/21 14:55
 */
@Controller
public class ShopController {

    @RequestMapping("/shopController")
    public String shopController() {
        return "shop";
    }

}
