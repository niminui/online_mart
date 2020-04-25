package com.nmh.online_mart.interceptor;

import com.nmh.online_mart.mapper.AdministratorMapper;
import com.nmh.online_mart.mapper.UserMapper;
import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.model.AdministratorExample;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author niminui
 * @date 2020/4/20 16:49
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = "", AToken = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
                if(cookie.getName().equals("AToken")) {
                    AToken = cookie.getValue();
                    break;
                }
            }
        }
        if((!StringUtils.isEmpty(token)) && (StringUtils.isEmpty(AToken))) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andTokenEqualTo(token);
            List<User> users = userMapper.selectByExample(userExample);
            if (users != null && users.size() != 0) {
                request.getSession().setAttribute("user", users.get(0));
            }
            return true;
        } else if ((StringUtils.isEmpty(token)) && (!StringUtils.isEmpty(AToken))) {
            AdministratorExample administratorExample = new AdministratorExample();
            administratorExample.createCriteria().andATokenEqualTo(AToken);
            List<Administrator> administrators = administratorMapper.selectByExample(administratorExample);
            if(administrators != null && administrators.size() != 0) {
                request.getSession().setAttribute("administrator",administrators.get(0));
            }
            return true;
        } else if ((StringUtils.isEmpty(token)) && (StringUtils.isEmpty(AToken))) {
            response.sendRedirect("/noLogin");
            return false;
        } else {
            throw new RuntimeException();
        }
    }
}
