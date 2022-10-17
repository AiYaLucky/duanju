package com.shortstv;

import com.google.gson.Gson;

/**
 * @Author xu xiao wei
 * @description 回客户端的数据模型
 * @ClassName shortsTV
 * @Package com.shortstv
 * @Date 2022/9/24 23:23
 * @Version 1.0
 */
public class BackClient {
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

    public BackClient() {
    }

    public BackClient(Integer code, String desc, String data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

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

    public String toJson() {
        return new Gson().toJson(this);
    }
}
