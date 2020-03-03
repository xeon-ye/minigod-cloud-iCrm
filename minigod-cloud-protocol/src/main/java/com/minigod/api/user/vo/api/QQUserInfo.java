package com.minigod.api.user.vo.api;

import java.io.Serializable;

/**
 * Created by kenkou on 2016/3/24.
 */
public class QQUserInfo implements Serializable {

    private static final long serialVersionUID = -1543247931592893262L;

    private String ret;
    private String openid;//普通用户的标识，对当前开发者帐号唯一
    private String nickname;//普通用户昵称
    private Integer sex;//普通用户性别，1为男性，2为女性
    private String gender;
    private String province;//普通用户个人资料填写的省份
    private String city;//普通用户个人资料填写的城市
    private String country;//国家，如中国为CN
    //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
    private String figureurl_qq_1;//http://q.qlogo.cn/qqapp/100312990/DE1931D5330620DBD07FB4A5422917B6/40

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public Boolean getSexYQNBoolean() {
        if (sex != null && sex > 0) {
            if (sex == 1) {
                return true;
            } else if (sex == 2) {
                return false;
            } else {
                throw new RuntimeException("QQ数据性别类型异常，其值为" + sex);
            }
        }
        return null;
    }

    public Integer getSexYQNInt() {
        if (sex != null && sex > 0) {
            if (sex == 1) {
                return 1;
            } else if (sex == 2) {
                return 0;
            } else {
                throw new RuntimeException("QQ数据性别类型异常，其值为" + sex);
            }
        }
        return null;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
