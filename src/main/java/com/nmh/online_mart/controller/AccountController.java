package com.nmh.online_mart.controller;

import com.nmh.online_mart.dto.MsgDTO;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author niminui
 * @date 2020/4/22 11:07
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/myAccount")
    public String myAccount(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "my-account";
    }

    @RequestMapping("/updateNyAccount")
    public String updateMyAccount(User user, HttpServletRequest request) {
        User sessionUser = (User) request.getSession().getAttribute("user");
        user.setId(sessionUser.getId());
        user.setGmtModified(System.currentTimeMillis());
        if(StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(null);
        }
        accountService.updateSelectAccount(user);
        return "redirect:/updateSuccess";
    }

    @RequestMapping(value = "/checkPw", method = RequestMethod.POST)
    @ResponseBody
    public MsgDTO checkPw(@RequestParam("password")String password) {
        boolean b = accountService.checkPassword(password);
        if(b) {
            return MsgDTO.success();
        } else {
            return MsgDTO.fail().add("pw","当前密码错误，请重新输入！");
        }
    }

    @RequestMapping("/updateSuccess")
    public String LoginSuccess() {
        return "updateSuccess";
    }

}
