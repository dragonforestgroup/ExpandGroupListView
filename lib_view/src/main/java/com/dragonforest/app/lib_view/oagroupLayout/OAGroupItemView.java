package com.dragonforest.app.lib_view.oagroupLayout;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dragonforest.app.lib_view.R;
import com.dragonforest.app.lib_view.oagroupLayout.adapter.OAItemRecyclerAdapter;
import com.dragonforest.app.lib_view.oagroupLayout.bean.OAItem;

import java.util.ArrayList;
import java.util.List;

/**
 * OA 单条view
 * 包含标题,  RecycleView
 *
 * @author 韩龙林
 * @date 2019/10/10 19:52
 */
public class OAGroupItemView extends LinearLayout {

    private RelativeLayout headLayout;
    private LinearLayout contentLayout;
    private TextView tv_oa_title;
    private RecyclerView oaItemRecyclerView;

    private String title;
    private List<OAItem> oaItemList;
    private int column = 4;

    public OAGroupItemView(Context context) {
        super(context);
        initView(context);
    }

    public OAGroupItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.libview_item_oagroup, this);
        tv_oa_title = findViewById(R.id.tv_oa_title);
        oaItemRecyclerView = findViewById(R.id.recyclerView);
        headLayout = findViewById(R.id.headLayout);
        contentLayout = findViewById(R.id.contentLayout);
        initRecycleView(oaItemRecyclerView, context);
    }

    private void initRecycleView(RecyclerView recyclerView, Context context) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        OAItemRecyclerAdapter adapter = new OAItemRecyclerAdapter(context, new ArrayList<OAItem>());
        recyclerView.setAdapter(adapter);
    }

    public void setColumn(int count) {
        this.column = count;
        ((GridLayoutManager) oaItemRecyclerView.getLayoutManager()).setSpanCount(count);
    }

    public int getColumn() {
        return column;
    }

    public void setTitle(final String title) {
        this.title = title;
        tv_oa_title.setText(title);
    }

    public void setOaItemList(final List<OAItem> oaItemList) {
        this.oaItemList = oaItemList;
        ((OAItemRecyclerAdapter) oaItemRecyclerView.getAdapter()).setData(oaItemList);
    }


    public void setItemOnClickListener(OAItemRecyclerAdapter.OARecyclerViewItemClickListener oaRecyclerViewItemClickListener) {
        ((OAItemRecyclerAdapter) oaItemRecyclerView.getAdapter()).setoARecyclerViewItemClickListener(oaRecyclerViewItemClickListener);
    }


    // 扩展

    public void showHead(boolean isShowHead) {
        if (isShowHead) {
            headLayout.setVisibility(VISIBLE);
        } else {
            headLayout.setVisibility(GONE);
        }
    }

    public TextView getTv_oa_title() {
        return tv_oa_title;
    }

    public RecyclerView getOaItemRecyclerView() {
        return oaItemRecyclerView;
    }
}
