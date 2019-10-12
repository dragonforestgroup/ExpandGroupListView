package com.dragonforest.app.lib_view.oagroupLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dragonforest.app.lib_view.R;
import com.dragonforest.app.lib_view.expandsplitlayout.ExpandableSplitLayout;
import com.dragonforest.app.lib_view.oagroupLayout.adapter.OAItemRecyclerAdapter;
import com.dragonforest.app.lib_view.oagroupLayout.bean.OAGroup;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * 实现OA列表可伸缩布局
 * <br></>包含头布局，和内容布局（包含一个或多个事务列表集合）
 *
 * @author 韩龙林
 * @date 2019/10/12 10:16
 */
public class OAGroupLayout extends ExpandableSplitLayout {

    private TextView tv_oa_title;
    private TextView tv_expand;

    private Context context;
    private List<OAGroup> oaGroups;
    private int column = 4;
    private int dividerHeight = 0;

    /**
     * 当前包含的OAGroupItemView集合
     */
    private List<OAGroupItemView> oaGroupItemViews = new ArrayList<>();
    /**
     * 每一项oa的监听事件
     */
    private OAItemRecyclerAdapter.OARecyclerViewItemClickListener oaRecyclerViewItemClickListener;

    public OAGroupLayout(Context context) {
        super(context);
    }

    public OAGroupLayout(Context context, boolean showCard) {
        super(context, showCard);
    }

    public OAGroupLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OAGroupLayout(Context context, AttributeSet attrs, boolean showCard) {
        super(context, attrs, showCard);
    }

    @Override
    public void initView(Context context, boolean showAsCard) {
        this.context = context;
        super.initView(context, showAsCard);
        View headView = LayoutInflater.from(context).inflate(R.layout.libview_oagroup_head, null, false);
        setHeadLayout(headView);
        initOAHeadView(headView);
    }

    private void initOAHeadView(View headView) {
        tv_oa_title = findViewById(R.id.tv_oa_title);
        tv_expand = findViewById(R.id.tv_expand);
        tv_oa_title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse();
                changeText();
            }
        });
        tv_expand.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse();
                changeText();
            }
        });
    }

    private void changeText() {
        if(isExpanded()){
            tv_expand.setText("收起");
        }else{
            tv_expand.setText("展开");
        }
    }

    public void setData(List<OAGroup> oaGroups) {
        this.oaGroups = oaGroups;
        oaGroupItemViews.clear();
        clearContentViews();
        for (int i = 0; i < oaGroups.size(); i++) {
            OAGroup oaGroup = oaGroups.get(i);
            OAGroupItemView oaGroupItemView = new OAGroupItemView(context);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = dividerHeight;
            oaGroupItemView.setLayoutParams(params);
            oaGroupItemView.setTitle(oaGroup.getTitle());
            oaGroupItemView.setOaItemList(oaGroup.getOaItems());
            if (oaRecyclerViewItemClickListener != null) {
                oaGroupItemView.setItemOnClickListener(oaRecyclerViewItemClickListener);
            }
            addContentView(oaGroupItemView);
            oaGroupItemViews.add(oaGroupItemView);
            Log.e(TAG, "OAGroupView :添加oaItemGroupView");
        }
        Log.e(TAG, "OAGroupView 的childView:" + getContentViewCount());
    }

    public List<OAGroup> getData() {
        return oaGroups;
    }

    public void setItemOnClickListener(OAItemRecyclerAdapter.OARecyclerViewItemClickListener oaRecyclerViewItemClickListener) {
        this.oaRecyclerViewItemClickListener = oaRecyclerViewItemClickListener;
        for (OAGroupItemView oaGroupItemView : oaGroupItemViews) {
            oaGroupItemView.setItemOnClickListener(oaRecyclerViewItemClickListener);
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
     * should use before setData()
     *
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

}
