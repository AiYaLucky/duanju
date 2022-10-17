package com.shortstv.service;

import com.shortstv.BackClient;
import com.shortstv.vo.LoginVo;
import com.shortstv.vo.RegisterVo;

/**
 * @Author xu xiao wei
 * @description 针对表【user】的数据库操作Service
 * @ClassName UserService
 * @Package com.shortstv.service
 * @Date 2022/9/24 22:47
 * @Version 1.0
 */
public interface UserService {

    /**
     * 用户登录
     * @param loginVo 登录信息
     * @return 返回通用结构
     */
    BackClient login(LoginVo loginVo);

    /**
     * 用户注册处
     * @param registerVo 注册信息
     * @return 返回通用结构
     */
    BackClient register(RegisterVo registerVo);
}
