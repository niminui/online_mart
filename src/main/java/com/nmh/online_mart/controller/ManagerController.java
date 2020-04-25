package com.nmh.online_mart.controller;

import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author niminui
 * @date 2020/4/22 13:20
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/managerLoginTemp")
    public String managerLogin() {
        return "manager-login";
    }

    @RequestMapping("/managerPage")
    public String managerPage() {
        return "manager-page";
    }

    @RequestMapping("/managerLogin")
    public String managerLogin(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        Administrator administrator = managerService.administratorLogin(name,password);
        if(administrator == null) {
            return "redirect:/loginFail";
        }
        response.addCookie(new Cookie("AToken",administrator.getaToken()));
        return "redirect:/loginSuccess";
    }



}
