package com.shortstv.service.impl;

import com.shortstv.BackClient;
import com.shortstv.config.ResultCode;
import com.shortstv.config.ResultDesc;
import com.shortstv.entity.User;
import com.shortstv.mapper.UserMapper;
import com.shortstv.service.UserService;
import com.shortstv.utils.GsonUtil;
import com.shortstv.vo.LoginVo;
import com.shortstv.vo.RegisterVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xu xiao wei
 * @description 针对表【user】的数据库操作Service实现
 * @ClassName UserServiceImpl
 * @Package com.shortstv.service.impl
 * @Date 2022/9/24 22:47
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private static ConcurrentHashMap<String, User> ALL_USERS = new ConcurrentHashMap<String, User>();

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
        if (ALL_USERS.size() <= 0) {
            List<User> allUsers = userMapper.getAllUsers();
            for (User user : allUsers) {
                ALL_USERS.put(user.getAccount(), user);
            }
        }
    }

    @Override
    public BackClient login(LoginVo loginVo) {
        BackClient toClient = new BackClient(ResultCode.LOGIN_SUCCESS, ResultDesc.LOGIN_SUCCESS, "");
        if (!ALL_USERS.containsKey(loginVo.getAccount())) {
            //没有的话去服务器再查询确认一次
            User userFromDb = userMapper.getUserByAccount(loginVo.getAccount());
            if (userFromDb == null) {
                toClient.setCode(ResultCode.LOGIN_ACCOUNT_ERROR);
                toClient.setDesc(ResultDesc.NO_THIS_PLAYER);
                return toClient;
            } else {
                ALL_USERS.put(userFromDb.getAccount(), userFromDb);
            }
        }

        User user = ALL_USERS.get(loginVo.getAccount());

        //密码验证
        if (!loginVo.getPassword().equals(user.getPassword())) {
            toClient.setCode(ResultCode.LOGIN_PASSWORD_ERROR);
            toClient.setDesc(ResultDesc.LOGIN_PASSWORD_ERROR);
            return toClient;
        }

        toClient.setCode(ResultCode.LOGIN_SUCCESS);
        toClient.setDesc(ResultDesc.LOGIN_SUCCESS);
        toClient.setData(GsonUtil.toJson(user));

        return toClient;
    }

    @Override
    public BackClient register(RegisterVo registerVo) {
        BackClient toClient = new BackClient(ResultCode.REGISTER_SUCCESS, ResultDesc.REGISTER_SUCCESS, "");

        /* 用户数据校验 */
        //两次输入密码校验
        if (!registerVo.getPassword().equals(registerVo.getRePassword())){
            toClient.setCode(ResultCode.REGISTER_PASSWARD_ERROR);
            toClient.setDesc(ResultDesc.REGISTER_PASSWORD_ERROR);
            return toClient;
        }

        //账号[手机]检测
        if (registerVo.getAccount().isEmpty()){
            toClient.setCode(ResultCode.REGISTER_FAIL_ACCOUNT_ERROR);
            toClient.setDesc(ResultDesc.REGISTER_FAIL_ACCOUNT_ERROR);
            return toClient;
        }
        /* 用户数据校验结束 */

        //给用户初始化相关信息
        User newUser = RegisterVo.init(registerVo);

        //用户插入数据库
        userMapper.insertUser(newUser);

        //添加到内存中
        ALL_USERS.put(newUser.getAccount(), newUser);

        //设置返回的数据内容
        toClient.setData(GsonUtil.toJson(newUser));

        return toClient;
    }


}
