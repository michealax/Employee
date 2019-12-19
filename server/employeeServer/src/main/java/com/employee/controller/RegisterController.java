package com.employee.controller;

import com.employee.entity.User;
import com.employee.request.RegisterRequest;
import com.employee.response.IDResponse;
import com.employee.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class RegisterController {
    @Resource
    UserService service;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    IDResponse register(@RequestBody RegisterRequest request) throws IOException {
        User user;
        String name = request.getUsername();
        String pwd = request.getPassword();
        String pwdConfim=request.getConfirmPassword();
        if (service.addUser(name,pwd,pwdConfim)) {
            user = service.getUser(name, pwd).get(0);
            System.out.println("注册成功");
            return new IDResponse(true, user.getInformationid());
        }
        return new IDResponse(false, -1);//失败ID就是-1
    }
}
