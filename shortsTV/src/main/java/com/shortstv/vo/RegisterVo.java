package com.shortstv.vo;

import com.shortstv.entity.User;

import java.util.UUID;

/**
 * @Author xu xiao wei
 * @description 用户注册信息模型
 * @ClassName shortsTV
 * @Package com.shortstv.vo
 * @Date 2022/9/24 23:04
 * @Version 1.0
 */
public class RegisterVo extends User {
    private String rePassword;

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    /**
     * 初始化注册用户的信息
     */
    public static User init(RegisterVo registerVo) {
        User user = new User();
        String uid = "";
        synchronized (uid) {
            uid = UUID.randomUUID().toString();
        }

        user.setUid(uid);
        //todo 以后做随机
        user.setNickname("以后做随机");
        //不用设置，前面已经校验过了
//        user.setAccount("");
//        user.setPassword("");
        user.setPhonenumber(registerVo.getPhonenumber());
        user.setAddress("");
        user.setLevel(1);
        user.setExp(0L);
        user.setVip(0);
        user.setGold(0L);
        user.setSilver(0L);
        user.setCopper(0L);
        user.setSign("还没有签名哦~");
        user.setVoice(1);
        user.setMusic(1);
        user.setRegistertime(System.currentTimeMillis());
        user.setLastlogin(System.currentTimeMillis());
        user.setLoginday(1);
        user.setPlatform("");
        user.setChannelid("");
        user.setIp("");
        user.setCountry("");
        return user;
    }
}
