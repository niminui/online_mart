package com.nmh.online_mart.service;

import com.nmh.online_mart.mapper.AdministratorMapper;
import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.model.AdministratorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niminui
 * @date 2020/4/22 13:55
 */
@Service
public class ManagerService {

    @Autowired
    private AdministratorMapper administratorMapper;

    public Administrator administratorLogin(String name, String password) {
        AdministratorExample example = new AdministratorExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<Administrator> administrators = administratorMapper.selectByExample(example);
        if(administrators == null || administrators.size() != 1) {
            return null;
        } else {
            return administrators.get(0);
        }
    }
}
