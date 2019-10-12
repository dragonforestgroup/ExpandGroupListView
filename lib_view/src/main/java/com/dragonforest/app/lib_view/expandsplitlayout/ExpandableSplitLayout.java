package com.dragonforest.app.lib_view.expandsplitlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dragonforest.app.lib_view.R;
import com.dragonforest.app.lib_view.expandlayout.ExpandableLayout;

/**
 * 可伸展的分离式布局
 *
 * <br></>包含头布局和可伸展的内容布局
 * <br></>可自定义头布局和内容布局
 *
 * @author 韩龙林
 * @date 2019/10/12 09:29
 */
public class ExpandableSplitLayout extends LinearLayout {
    boolean isExpanded = true;

    Context context;

    private ExpandableLayout expandableLayout;
    private LinearLayout contentLayout;
    private RelativeLayout headLayout;

    public ExpandableSplitLayout(Context context) {
        super(context);
        initView(context, true);
    }

    public ExpandableSplitLayout(Context context, boolean showCard) {
        super(context);
        initView(context, showCard);
    }

    public ExpandableSplitLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, true);
    }

    public ExpandableSplitLayout(Context context, AttributeSet attrs, boolean showCard) {
        super(context, attrs);
        initView(context, showCard);
    }

    public void initView(Context context, boolean showAsCard) {
        this.context = context;
        if (showAsCard) {
            LayoutInflater.from(context).inflate(R.layout.libview_expandsplitlayout_card, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.libview_expandsplitlayout, this);
        }
        expandableLayout = findViewById(R.id.expandableContentLayout);
        contentLayout = findViewById(R.id.contentLayout);
        headLayout = findViewById(R.id.headLayout);
    }

    public void expand() {
        expandableLayout.setExpanded(true);
        this.isExpanded = true;
    }

    public void collapse() {
        expandableLayout.setExpanded(false);
        this.isExpanded = false;
    }

    public void expandOrCollapse() {
        if (isExpanded) {
            collapse();
        } else {
            expand();
        }
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setHeadLayout(View v) {
        headLayout.removeAllViews();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        headLayout.addView(v, params);
    }

    public void setContentView(View v) {
        contentLayout.removeAllViews();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        contentLayout.addView(v, params);
    }

    public void addContentView(View v) {
        contentLayout.addView(v);
    }

    public void clearContentViews() {
        contentLayout.removeAllViews();
    }

    public int getContentViewCount() {
        return contentLayout.getChildCount();
    }

    // 扩展

    public void showHead(boolean isShowHead) {
        if (isShowHead) {
            headLayout.setVisibility(VISIBLE);
        } else {
            headLayout.setVisibility(GONE);
        }
    }

    public LinearLayout getContentLayout() {
        return contentLayout;
    }

    public ExpandableLayout getExpandableLayout() {
        return expandableLayout;
    }
}
