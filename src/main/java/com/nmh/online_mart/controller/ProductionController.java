package com.nmh.online_mart.controller;

import com.nmh.online_mart.mapper.ProductInformationMapper;
import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.model.ProductInformation;
import com.nmh.online_mart.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author niminui
 * @date 2020/4/23 11:34
 */
@Controller
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    @RequestMapping("/saveProductionInformation")
    public String saveProductionInformation(ProductInformation productInformation, HttpServletRequest request) {
        productInformation.setAvatarUrl((String) request.getSession().getAttribute("fileName"));
        request.getSession().removeAttribute("fileName");

        productInformation.setGmtCreate(System.currentTimeMillis());
        productInformation.setGmtModified(System.currentTimeMillis());
        productInformation.setAdministratorId(((Administrator)(request.getSession().getAttribute("administrator"))).getId());

        boolean b = productionService.saveProduction(productInformation);
        if(b) {
            return "redirect:/productAddSuccess";
        } else {
            throw new RuntimeException();
        }
    }

}
