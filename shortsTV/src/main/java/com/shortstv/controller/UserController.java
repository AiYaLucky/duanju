package com.shortstv.controller;

import com.shortstv.BackClient;
import com.shortstv.service.UserService;
import com.shortstv.vo.LoginVo;
import com.shortstv.vo.RegisterVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xu xiao wei
 * @description User控制器
 * @ClassName UserController
 * @Package com.shortstv.controller
 * @Date 2022/9/24 23:03
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(@RequestBody LoginVo loginData) {
        BackClient login = userService.login(loginData);
        return login.toJson();
    }

    @RequestMapping("/register")
    public String doRegister(RegisterVo registerVo) {
        BackClient register = userService.register(registerVo);
        return register.toJson();
    }
}
