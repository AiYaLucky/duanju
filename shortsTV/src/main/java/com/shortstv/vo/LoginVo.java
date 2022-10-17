package com.shortstv.vo;

/**
 * @Author xu xiao wei
 * @description 用户登录数据模型
 * @ClassName LoginVo
 * @Package com.shortstvserver.vo
 * @Date 2022/9/24 19:08
 * @Version 1.0
 */
public class LoginVo {

    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checnInfo() {
        if (this.account == null || this.password == null) {
            return false;
        }
        return true;
    }
}
