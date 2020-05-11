package com.nmh.online_mart.controller;

import com.nmh.online_mart.model.ProductInformation;
import com.nmh.online_mart.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author niminui
 * @date 2020/4/20 11:47
 */
@Controller
public class IndexController {

    @Autowired
    private ProductionService productionService;

    @RequestMapping(value = {"/","/index"})
    public String indexPage(Model model) {
        //查询最新修改的 8 前个商品
        List<ProductInformation> productionsOrderBy = productionService.showProductionListOrderByGmtModified();
        model.addAttribute("productionsOrderBy",productionsOrderBy);
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

    @RequestMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/paymentSuccess")
    public String paymentSuccess() {
        return "paymentSuccess";
    }

    @RequestMapping("/orderDetails")
    public String orderDetails() {
        return "orderDetails";
    }

    @RequestMapping("/postNotice")
    public String postNotice() {
        return "manager-notice";
    }


}
