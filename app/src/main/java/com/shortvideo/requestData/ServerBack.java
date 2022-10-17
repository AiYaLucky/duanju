package com.shortvideo.requestData;

/**
 * 接收服务器返回的通用结构
 * @Author: xu xiao wei
 * @Date: 2022/10/17 23:15
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class ServerBack {
    /**
     * 返回的状态码
     */
    private Integer code;
    /**
     * 返回的内容说明
     */
    private String desc;
    /**
     * 返回的具体数据
     */
    private String data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
