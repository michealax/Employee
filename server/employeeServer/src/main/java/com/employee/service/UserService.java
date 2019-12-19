package com.employee.service;

import com.employee.dao.UserDao;
import com.employee.entity.User;
import com.employee.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getUser(String name){
        UserExample userExample=new UserExample();
        userExample.or().andNameEqualTo("abc").andPasswordEqualTo("123");
        userExample.or().andInformationidEqualTo(1).andIdGreaterThan(1);
// select from user where (name=abc and password=123) or (information=1 and id >1)
//        userDao.selectByPrimaryKey(1);
        return userDao.selectByExample(userExample);
    }
}
