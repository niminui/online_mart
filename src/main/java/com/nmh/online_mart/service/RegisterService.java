package com.nmh.online_mart.service;

import com.nmh.online_mart.mapper.UserMapper;
import com.nmh.online_mart.model.User;
import com.nmh.online_mart.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niminui
 * @date 2020/4/20 15:20
 */
@Service
public class RegisterService {

    @Autowired
    private UserMapper userMapper;

    public int registerUser(User user) {
        return userMapper.insertSelective(user);
    }

    public boolean checkEmail(String email) {
        UserExample emailExample = new UserExample();
        emailExample.createCriteria().andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(emailExample);
        if(users.size() == 1) {
            return false;
        } else if (users.size() == 0){
            return true;
        } else {
            throw new RuntimeException();
        }
    }
}
