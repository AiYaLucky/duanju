package com.aiyalucky.duanju.config;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/19 21:08
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public enum SPKEY {
    /*记录用户相关数据的枚举KEY*/
    USER_LOGIN_TIME("userLoginTime"),
    USER_ACCOUNT("userAccount"),
    USER_PASSWORD("userPassword"),
    USER_AUTO_LOGIN("autoLogin"),
    ;

    //     public static final String USER_LOGIN_TIME = "userLoginTime";
    private final String text;

    SPKEY(String text) {
        this.text = text;
    }

    public String getString() {
        return this.text;
    }
}
