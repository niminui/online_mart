package com.nmh.online_mart.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niminui
 * @date 2020/4/20 17:01
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**").excludePathPatterns(getUserUrls());
    }

    private List<String> getUserUrls() {
        List<String> list = new ArrayList<>();
        //主页及用户Controller
        list.add("/");
        list.add("/loginOrRegister");
        list.add("/noLogin");
        list.add("/login");
        list.add("/register");
        list.add("/logout");
        list.add("/loginFail");
        list.add("/checkEmail");

        //管理员Controller
        list.add("/managerLoginTemp");
        list.add("/managerLogin");
        list.add("/managerPage");

        //静态资源文件
        list.add("/assets/**");
        list.add("/documentation/**");
        list.add("/scss/**");

        //文件上传
        list.add("/file/uploadProduction");
        return list;
    }

}
