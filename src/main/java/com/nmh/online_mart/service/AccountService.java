package com.nmh.online_mart.service;

import com.nmh.online_mart.mapper.UserMapper;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author niminui
 * @date 2020/4/22 12:14
 */
@Service
public class AccountService {

    @Autowired
    private UserMapper userMapper;

    public boolean checkPassword(String password) {
        UserExample passwordExample = new UserExample();
        passwordExample.createCriteria().andPasswordEqualTo(password);
        return userMapper.selectByExample(passwordExample).size() == 1;
    }

    public void updateSelectAccount(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
