package com.employee.service;

import com.employee.dao.PersonalDao;
import com.employee.dao.UserDao;
import com.employee.entity.Personal;
import com.employee.entity.PersonalExample;
import com.employee.entity.User;
import com.employee.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserDao userDao;
    private PersonalDao personalDao;

    public List<User> getUser(String name, String password) {
        //构建sql语句
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
//        userExample.or().andInformationidEqualTo(1).andIdGreaterThan(1);
//        select from user where (name=abc and password=123) or (information=1 and id >1)
//        userDao.selectByPrimaryKey(1);
        return userDao.selectByExample(userExample);
    }

    public boolean addUser(String name, String password, String confimPassword) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        if (userDao.selectByExample(userExample).size() == 0 && password.equals(confimPassword)) {
            Personal personal=new Personal();
            personal.setName(name);
            personalDao.insertSelective(personal);

            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setIscompany(0);
            int personID=-1;

            PersonalExample personalExample=new PersonalExample();
            personalExample.createCriteria().andNameEqualTo(name);
            if (personalDao.selectByExample(personalExample).size() != 0){
                personID=personalDao.selectByExample(personalExample).get(0).getId();
            }
            user.setInformationid(personID);
            userDao.insertSelective(user);
            return true;
        }
        return false;
    }
}
