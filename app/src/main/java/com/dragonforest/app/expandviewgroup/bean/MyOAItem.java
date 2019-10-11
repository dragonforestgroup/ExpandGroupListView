package com.dragonforest.app.expandviewgroup.bean;

import java.io.Serializable;

/**
 * 用来测试 用来被携带 我自定义的数据
 *
 * @author 韩龙林
 * @date 2019/10/11 18:44
 */
public class MyOAItem implements Serializable {
    String ssid;
    String address;
    String phone;

    public MyOAItem(String ssid, String address, String phone) {
        this.ssid = ssid;
        this.address = address;
        this.phone = phone;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
