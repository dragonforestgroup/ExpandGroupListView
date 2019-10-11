package com.dragonforest.app.lib_view.oagroupLayout.bean;

import java.io.Serializable;

/**
 * @author 韩龙林
 * @date 2019/10/10 20:11
 */
public class OAItem implements Serializable {
    int imgId;
    String imgUrl;
    String oaName;

    public OAItem(int imgId, String imgUrl, String oaName) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
        this.oaName = oaName;
    }

    public OAItem(int imgId, String oaName) {
        this.imgId = imgId;
        this.oaName = oaName;
    }

    public OAItem() {
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getOaName() {
        return oaName;
    }

    public void setOaName(String oaName) {
        this.oaName = oaName;
    }
}
