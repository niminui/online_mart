package com.nmh.online_mart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author niminui
 * @date 2020/4/20 11:47
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/loginFail")
    public String LoginSuccess() {
        return "loginFail";
    }

    @RequestMapping("/noLogin")
    public String noLogin() {
        return "no_login";
    }

    @RequestMapping("/productAddSuccess")
    public String proAddSuccess() {
        return "product_add_success";
    }

}
