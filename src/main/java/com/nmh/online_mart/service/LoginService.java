package com.nmh.online_mart.service;

import com.nmh.online_mart.mapper.UserMapper;
import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niminui
 * @date 2020/4/20 15:31
 */
@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public User userLogin(String email, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() != 1) {
            return null;
        } else {
            return users.get(0);
        }
    }
}
