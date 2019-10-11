package com.dragonforest.app.lib_view.oagroupLayout.bean;

import java.io.Serializable;
import java.util.List;

/**
 * OAGroup OA组类   包含标题和OAItrem列表
 *
 * @author 韩龙林
 * @date 2019/10/10 20:54
 */
public class OAGroup implements Serializable {
    String title;
    List<OAItem> oaItems;

    public OAGroup() {
    }

    public OAGroup(String title, List<OAItem> oaItems) {
        this.title = title;
        this.oaItems = oaItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<OAItem> getOaItems() {
        return oaItems;
    }

    public void setOaItems(List<OAItem> oaItems) {
        this.oaItems = oaItems;
    }
}
