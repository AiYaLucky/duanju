package com.aiyalucky.duanju.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/20 0:43
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */

public class User {

    @SerializedName("uid")
    private String uid;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("account")
    private String account;
    @SerializedName("password")
    private String password;
    @SerializedName("phone")
    private Long phone;
    @SerializedName("address")
    private String address;
    @SerializedName("level")
    private Integer level;
    @SerializedName("exp")
    private Integer exp;
    @SerializedName("viplevel")
    private Integer viplevel;
    @SerializedName("vipexp")
    private Integer vipexp;
    @SerializedName("gold")
    private Integer gold;
    @SerializedName("silver")
    private Integer silver;
    @SerializedName("copper")
    private Integer copper;
    @SerializedName("sign")
    private String sign;
    @SerializedName("voice")
    private Integer voice;
    @SerializedName("music")
    private Integer music;
    @SerializedName("registertime")
    private Long registertime;
    @SerializedName("lastlogin")
    private Long lastlogin;
    @SerializedName("loginday")
    private Integer loginday;
    @SerializedName("platform")
    private String platform;
    @SerializedName("ip")
    private String ip;
    @SerializedName("country")
    private String country;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getViplevel() {
        return viplevel;
    }

    public void setViplevel(Integer viplevel) {
        this.viplevel = viplevel;
    }

    public Integer getVipexp() {
        return vipexp;
    }

    public void setVipexp(Integer vipexp) {
        this.vipexp = vipexp;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getCopper() {
        return copper;
    }

    public void setCopper(Integer copper) {
        this.copper = copper;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getVoice() {
        return voice;
    }

    public void setVoice(Integer voice) {
        this.voice = voice;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public Long getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Long registertime) {
        this.registertime = registertime;
    }

    public Long getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Long lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Integer getLoginday() {
        return loginday;
    }

    public void setLoginday(Integer loginday) {
        this.loginday = loginday;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
