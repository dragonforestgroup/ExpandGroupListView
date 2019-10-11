package com.dragonforest.app.lib_view.oagroupLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dragonforest.app.lib_view.R;
import com.dragonforest.app.lib_view.expandlayout.ExpandableLayout;
import com.dragonforest.app.lib_view.oagroupLayout.adapter.OAItemRecyclerAdapter;
import com.dragonforest.app.lib_view.oagroupLayout.bean.OAGroup;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * 伸缩办公布局集合
 *
 * @author 韩龙林
 * @date 2019/10/10 19:52
 */
public class OAGroupView extends LinearLayout {

    boolean isExpanded = true;

    Context context;

    private TextView tv_oa_title;
    private TextView tv_expand;
    private ExpandableLayout expandableLayout;
    private LinearLayout contentLayout;
    private RelativeLayout headLayout;

    private String title;
    private List<OAGroup> oaGroups;
    private int column = 4;
    private int dividerHeight=0;

    /**
     * 当前包含的OAGroupItemView集合
     */
    private List<OAGroupItemView> oaGroupItemViews = new ArrayList<>();
    /**
     * 每一项oa的监听事件
     */
    private OAItemRecyclerAdapter.OARecyclerViewItemClickListener oaRecyclerViewItemClickListener;

    public OAGroupView(Context context) {
        super(context);
        initView(context);
    }

    public OAGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.libview_oagroup, this);
        tv_oa_title = findViewById(R.id.tv_oa_title);
        tv_expand = findViewById(R.id.tv_expand);
        expandableLayout = findViewById(R.id.expandableContentLayout);
        contentLayout = findViewById(R.id.contentLayout);
        headLayout = findViewById(R.id.headLayout);
        tv_expand.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse();
            }
        });
        tv_oa_title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse();
            }
        });
    }

    public void expand() {
        expandableLayout.setExpanded(true);
    }

    public void collapse() {
        expandableLayout.setExpanded(false);
    }

    public void expandOrCollapse() {
        if (isExpanded) {
            tv_expand.setText("展开");
            collapse();
        } else {
            tv_expand.setText("收起");
            expand();
        }
        isExpanded = !isExpanded;
    }

    public void setTitle(String title) {
        this.title = title;
        tv_oa_title.setText(title);
    }

    public void setData(List<OAGroup> oaGroups) {
        this.oaGroups = oaGroups;
        contentLayout.removeAllViews();
        oaGroupItemViews.clear();
        for (int i = 0; i < oaGroups.size(); i++) {
            OAGroup oaGroup = oaGroups.get(i);
            OAGroupItemView oaGroupItemView = new OAGroupItemView(context);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin=dividerHeight;
            oaGroupItemView.setLayoutParams(params);
            oaGroupItemView.setTitle(oaGroup.getTitle());
            oaGroupItemView.setOaItemList(oaGroup.getOaItems());
            if (oaRecyclerViewItemClickListener != null) {
                oaGroupItemView.setItemOnClickListener(oaRecyclerViewItemClickListener);
            }
            contentLayout.addView(oaGroupItemView);
            oaGroupItemViews.add(oaGroupItemView);
            Log.e(TAG, "OAGroupView :添加oaItemGroupView");
        }
        Log.e(TAG, "OAGroupView 的childView:" + contentLayout.getChildCount());
    }

    public void setItemOnClickListener(OAItemRecyclerAdapter.OARecyclerViewItemClickListener oaRecyclerViewItemClickListener) {
        this.oaRecyclerViewItemClickListener = oaRecyclerViewItemClickListener;
        for (OAGroupItemView oaGroupItemView : oaGroupItemViews) {
            oaGroupItemView.setItemOnClickListener(oaRecyclerViewItemClickListener);
        }
    }

    // 扩展

    public void showHead(boolean isShowHead) {
        if (isShowHead) {
            headLayout.setVisibility(VISIBLE);
        } else {
            headLayout.setVisibility(GONE);
        }
    }

    public void showChildHead(boolean isShowChildHead) {
        for (OAGroupItemView oaGroupItemView : oaGroupItemViews) {
            oaGroupItemView.showHead(isShowChildHead);
        }
    }

    public void setColumn(int count) {
        this.column = count;
        for (OAGroupItemView oaGroupItemView : oaGroupItemViews) {
            oaGroupItemView.setColumn(count);
        }
    }

    public int getColumn() {
        return column;
    }

    /**
     * 设置内部间隔 需要在setData之前调用
     * @param dividerHeight
     */
    public void setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
    }

    public int getDividerHeight() {
        return dividerHeight;
    }

    public List<OAGroupItemView> getOaGroupItemViews() {
        return oaGroupItemViews;
    }

    public TextView getTv_oa_title() {
        return tv_oa_title;
    }

    public TextView getTv_expand() {
        return tv_expand;
    }

    public LinearLayout getContentLayout() {
        return contentLayout;
    }

    public ExpandableLayout getExpandableLayout() {
        return expandableLayout;
    }
}
