package com.shortstv.entity;

import java.io.Serializable;

/**
 * 
 * @TableName user
 */
public class User implements Serializable {
    /**
     * uid
     */
    private String uid;

    /**
     * 名字
     */
    private String nickname;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机
     */
    private String phonenumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 经验
     */
    private Long exp;

    /**
     * VIP等级
     */
    private Integer vip;

    /**
     * 金币
     */
    private Long gold;

    /**
     * 银币
     */
    private Long silver;

    /**
     * 铜币
     */
    private Long copper;

    /**
     * 签名
     */
    private String sign;

    /**
     * 声音开关
     */
    private Integer voice;

    /**
     * 音乐开关
     */
    private Integer music;

    /**
     * 注册时间
     */
    private Long registertime;

    /**
     * 最后一次登陆时间
     */
    private Long lastlogin;

    /**
     * 累计登陆天数
     */
    private Integer loginday;

    /**
     * 渠道标识
     */
    private String platform;

    /**
     * 渠道
     */
    private String channelid;

    /**
     * 注册Ip
     */
    private String ip;

    /**
     * 注册国家
     */
    private String country;

    private static final long serialVersionUID = 1L;

    /**
     * uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 名字
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 名字
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 手机
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 手机
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 经验
     */
    public Long getExp() {
        return exp;
    }

    /**
     * 经验
     */
    public void setExp(Long exp) {
        this.exp = exp;
    }

    /**
     * VIP等级
     */
    public Integer getVip() {
        return vip;
    }

    /**
     * VIP等级
     */
    public void setVip(Integer vip) {
        this.vip = vip;
    }

    /**
     * 金币
     */
    public Long getGold() {
        return gold;
    }

    /**
     * 金币
     */
    public void setGold(Long gold) {
        this.gold = gold;
    }

    /**
     * 银币
     */
    public Long getSilver() {
        return silver;
    }

    /**
     * 银币
     */
    public void setSilver(Long silver) {
        this.silver = silver;
    }

    /**
     * 铜币
     */
    public Long getCopper() {
        return copper;
    }

    /**
     * 铜币
     */
    public void setCopper(Long copper) {
        this.copper = copper;
    }

    /**
     * 签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 声音开关
     */
    public Integer getVoice() {
        return voice;
    }

    /**
     * 声音开关
     */
    public void setVoice(Integer voice) {
        this.voice = voice;
    }

    /**
     * 音乐开关
     */
    public Integer getMusic() {
        return music;
    }

    /**
     * 音乐开关
     */
    public void setMusic(Integer music) {
        this.music = music;
    }

    /**
     * 注册时间
     */
    public Long getRegistertime() {
        return registertime;
    }

    /**
     * 注册时间
     */
    public void setRegistertime(Long registertime) {
        this.registertime = registertime;
    }

    /**
     * 最后一次登陆时间
     */
    public Long getLastlogin() {
        return lastlogin;
    }

    /**
     * 最后一次登陆时间
     */
    public void setLastlogin(Long lastlogin) {
        this.lastlogin = lastlogin;
    }

    /**
     * 累计登陆天数
     */
    public Integer getLoginday() {
        return loginday;
    }

    /**
     * 累计登陆天数
     */
    public void setLoginday(Integer loginday) {
        this.loginday = loginday;
    }

    /**
     * 渠道标识
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 渠道标识
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 渠道
     */
    public String getChannelid() {
        return channelid;
    }

    /**
     * 渠道
     */
    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    /**
     * 注册Ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 注册Ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 注册国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 注册国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPhonenumber() == null ? other.getPhonenumber() == null : this.getPhonenumber().equals(other.getPhonenumber()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getExp() == null ? other.getExp() == null : this.getExp().equals(other.getExp()))
            && (this.getVip() == null ? other.getVip() == null : this.getVip().equals(other.getVip()))
            && (this.getGold() == null ? other.getGold() == null : this.getGold().equals(other.getGold()))
            && (this.getSilver() == null ? other.getSilver() == null : this.getSilver().equals(other.getSilver()))
            && (this.getCopper() == null ? other.getCopper() == null : this.getCopper().equals(other.getCopper()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getVoice() == null ? other.getVoice() == null : this.getVoice().equals(other.getVoice()))
            && (this.getMusic() == null ? other.getMusic() == null : this.getMusic().equals(other.getMusic()))
            && (this.getRegistertime() == null ? other.getRegistertime() == null : this.getRegistertime().equals(other.getRegistertime()))
            && (this.getLastlogin() == null ? other.getLastlogin() == null : this.getLastlogin().equals(other.getLastlogin()))
            && (this.getLoginday() == null ? other.getLoginday() == null : this.getLoginday().equals(other.getLoginday()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPhonenumber() == null) ? 0 : getPhonenumber().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getExp() == null) ? 0 : getExp().hashCode());
        result = prime * result + ((getVip() == null) ? 0 : getVip().hashCode());
        result = prime * result + ((getGold() == null) ? 0 : getGold().hashCode());
        result = prime * result + ((getSilver() == null) ? 0 : getSilver().hashCode());
        result = prime * result + ((getCopper() == null) ? 0 : getCopper().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getVoice() == null) ? 0 : getVoice().hashCode());
        result = prime * result + ((getMusic() == null) ? 0 : getMusic().hashCode());
        result = prime * result + ((getRegistertime() == null) ? 0 : getRegistertime().hashCode());
        result = prime * result + ((getLastlogin() == null) ? 0 : getLastlogin().hashCode());
        result = prime * result + ((getLoginday() == null) ? 0 : getLoginday().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", nickname=").append(nickname);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", address=").append(address);
        sb.append(", level=").append(level);
        sb.append(", exp=").append(exp);
        sb.append(", vip=").append(vip);
        sb.append(", gold=").append(gold);
        sb.append(", silver=").append(silver);
        sb.append(", copper=").append(copper);
        sb.append(", sign=").append(sign);
        sb.append(", voice=").append(voice);
        sb.append(", music=").append(music);
        sb.append(", registertime=").append(registertime);
        sb.append(", lastlogin=").append(lastlogin);
        sb.append(", loginday=").append(loginday);
        sb.append(", platform=").append(platform);
        sb.append(", channelid=").append(channelid);
        sb.append(", ip=").append(ip);
        sb.append(", country=").append(country);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}