package com.nmh.online_mart.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.model.ProductInformation;
import com.nmh.online_mart.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        String fileName1 = (String) request.getSession().getAttribute("fileName1");
        productInformation.setAvatarUrl(fileName1.substring(1,fileName1.length() - 1));
        request.getSession().removeAttribute("fileName1");

        String fileName2 = (String) request.getSession().getAttribute("fileName2");
        productInformation.setAvatarUrlDetails(fileName2.substring(1,fileName2.length() - 1));
        request.getSession().removeAttribute("fileName2");

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

    @RequestMapping("/showProductionList")
    public String showProductionList(@RequestParam(name = "page", defaultValue = "1")Integer page,
                                     @RequestParam(name = "size", defaultValue = "10")Integer size,
                                     Model model) {
        PageHelper.startPage(page,size);
        List<ProductInformation> productions = productionService.showProductionList();
        PageInfo<ProductInformation> pageInfo = new PageInfo<>(productions,size);
        model.addAttribute("productions",productions);
        model.addAttribute("pageInfo",pageInfo);
        return "shop-list";
    }

    @RequestMapping("/editProductionInformation")
        public String editProductionInformation(ProductInformation productInformation, HttpServletRequest request) {
        String fileName1 = (String) request.getSession().getAttribute("fileName1");
        String fileName2 = (String) request.getSession().getAttribute("fileName2");
        if(!StringUtils.isEmpty(fileName1)) {
            productInformation.setAvatarUrl(fileName1.substring(1,fileName1.length() - 1));
            request.getSession().removeAttribute("fileName1");
        } else {
            productInformation.setAvatarUrl(null);
        }

        if(!StringUtils.isEmpty(fileName2)) {
            productInformation.setAvatarUrlDetails(fileName2.substring(1,fileName2.length() - 1));
            productInformation.setGmtModified(System.currentTimeMillis());
            request.getSession().removeAttribute("fileName2");
        }
        else {
            productInformation.setAvatarUrlDetails(null);
        }
        boolean b = productionService.updateProductInformation(productInformation);
        return "redirect:/showProductionList";
    }

    @RequestMapping("/deleteProduction/{id}")
    public String deleteProduction(@PathVariable(value = "id")Long id) {
        boolean b = productionService.deleteProductionById(id);
        if(b) {
            return "redirect:/showProductionList";
        } else {
            throw new RuntimeException();
        }
    }

}
