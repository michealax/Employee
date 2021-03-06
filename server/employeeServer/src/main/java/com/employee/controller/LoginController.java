package com.employee.controller;

import com.employee.entity.User;
import com.employee.request.LoginRequest;
import com.employee.response.IDResponse;
import com.employee.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class LoginController {
    @Resource
    UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    IDResponse login(@RequestBody LoginRequest request) throws IOException {
        User user;
        String name = request.getUsername();
        String pwd = request.getPassword();
        if (service.getUser(name, pwd).size() != 0) {
            user = service.getUser(name, pwd).get(0);
            System.out.println("登录成功");
            return new IDResponse(true, user.getInformationid());
        }
        return new IDResponse(false, -1);//失败ID就是-1
    }
}
