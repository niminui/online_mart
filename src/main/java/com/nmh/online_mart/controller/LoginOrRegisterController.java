package com.nmh.online_mart.controller;

import com.nmh.online_mart.dto.MsgDTO;
import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.service.LoginService;
import com.nmh.online_mart.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author niminui
 * @date 2020/4/20 13:55
 */
@Controller
public class LoginOrRegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginOrRegister")
    public String loginOrRegister() {
        return "login-register";
    }

    /**
     * 用户登录
     * @param email 电子邮件
     * @param password 密码
     * @param response response
     * @return 跳转回主页
     */
    @RequestMapping("/login")
    public String login(@RequestParam("email")String email
            , @RequestParam("password")String password
            , HttpServletResponse response) {

        User user = loginService.userLogin(email, password);
        if(user == null) {
            return "redirect:/loginFail";
        } else {
            response.addCookie(new Cookie("token",user.getToken()));
        }
        return "redirect:/loginSuccess";
    }

    @RequestMapping("/loginSuccess")
    public String LoginSuccess() {
        return "loginSuccess";
    }

    /**
     * 注册用户
     * @param email 电子邮件
     * @param password 密码
     * @return 返回登录/注册页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("email")String email, @RequestParam("password")String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName("默认用户");
        user.setToken(UUID.randomUUID().toString());
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(System.currentTimeMillis());
        int isSuccess = registerService.registerUser(user);
        if(isSuccess == 1) {
            return "registerSuccess";
        } else {
            throw new RuntimeException();
        }
    }

    /**
     * 登出
     * @param request request
     * @param response response
     * @return 跳转回主页
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute("user");
        Administrator administrator = (Administrator)request.getSession().getAttribute("administrator");
        String role = "", rToken = "";
        if(user != null && administrator == null) {
            role = "user";
            rToken = "token";
        } else if (administrator != null && user == null){
            role = "administrator";
            rToken = "AToken";
        }
        request.getSession().removeAttribute(role);
        Cookie cookie = new Cookie(rToken,null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public MsgDTO checkEmail(@RequestParam("email")String email) {
        String regx = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        if(email == null || "".equals(email)) {
            return MsgDTO.fail().add("va_msg","邮箱不能为空!");
        } else if(!email.matches(regx)) {
            return MsgDTO.fail().add("va_msg","邮箱格式不正确!");
        }
        boolean check = registerService.checkEmail(email);
        if(check) {
            return MsgDTO.success();
        } else {
            return MsgDTO.fail().add("va_msg","该邮箱已被占用，请登录 或 请换一个邮箱试试?");
        }
    }

}
