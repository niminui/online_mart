package com.nmh.online_mart.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nmh.online_mart.model.ProductInformation;
import com.nmh.online_mart.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author niminui
 * @date 2020/4/21 14:55
 */
@Controller
public class ShopController {

    @Autowired
    private ProductionService productionService;

    @RequestMapping("/shopController")
    public String shopController(@RequestParam(name = "page", defaultValue = "1")Integer page,
                                 @RequestParam(name = "size", defaultValue = "10")Integer size,
                                 Model model) {
        PageHelper.startPage(page,size);
        List<ProductInformation> productions = productionService.showProductionList();
        PageInfo<ProductInformation> pageInfo = new PageInfo<>(productions,size);
        model.addAttribute("productions",productions);
        model.addAttribute("pageInfo",pageInfo);
        return "shop-list-user";
    }

}
