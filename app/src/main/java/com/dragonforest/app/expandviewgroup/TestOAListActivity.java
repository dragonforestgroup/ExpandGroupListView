package com.dragonforest.app.expandviewgroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dragonforest.app.expandviewgroup.bean.MyOAItem;
import com.dragonforest.app.lib_view.expandsplitlayout.ExpandableSplitLayout;
import com.dragonforest.app.lib_view.oagroupLayout.OAGroupLayout;
import com.dragonforest.app.lib_view.oagroupLayout.adapter.OAItemRecyclerAdapter;
import com.dragonforest.app.lib_view.oagroupLayout.bean.OAGroup;
import com.dragonforest.app.lib_view.oagroupLayout.bean.OAItem;
import com.dragonforest.app.lib_view.scrolllinearlayout.ScrollLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TestOAListActivity extends AppCompatActivity {

    private OAGroupLayout oaGroupView_use;
    private OAGroupLayout oaGroupView;
    private OAGroupLayout oaGroupView2;
    private ExpandableSplitLayout expandSplitLayout;
    private ScrollLinearLayout scrollLinearLayout;
    private TextView tv_head_expand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_oalist);
        initView();
    }

    private void initView() {
        scrollLinearLayout = findViewById(R.id.scrollLinearLayout);
        initOaGroupView();
        initExpandSplitLayout();
    }

    private void initOaGroupView() {
        MyOAItem data = new MyOAItem("1501295534", "北京市海淀区", "123456789xxx");

        //  1.创建模拟数据
        //  常用中的数据
        List<OAGroup> oaGroups_use = new ArrayList<>();
        List<OAItem> listuu = new ArrayList<>();
        listuu.add(new OAItem(R.drawable.libview_oa_dayoff, "请假", data));
        listuu.add(new OAItem(R.drawable.libview_oa_mail, "邮件", data));
        listuu.add(new OAItem(R.drawable.libview_oa_checkin, "打卡", data));
        listuu.add(new OAItem(R.drawable.libview_oa_money, "报销", data));
        oaGroups_use.add(new OAGroup("人事jj", listuu));

        // OA,订单的数据（复用同一个）
        List<OAGroup> oaGroups = new ArrayList<>();
        List<OAItem> list1 = new ArrayList<>();
        list1.add(new OAItem(R.drawable.libview_oa_dayoff, "请假1"));
        list1.add(new OAItem(R.drawable.libview_oa_mail, "邮件1"));
        list1.add(new OAItem(R.drawable.libview_oa_checkin, "打卡1"));
        list1.add(new OAItem(R.drawable.libview_oa_money, "报销1"));
        list1.add(new OAItem(R.drawable.libview_oa_car, "用车1"));
        list1.add(new OAItem(R.drawable.libview_oa_check, "审批1"));
        oaGroups.add(new OAGroup("人事", list1));
        List<OAItem> list2 = new ArrayList<>();
        list2.add(new OAItem(R.drawable.libview_oa_dayoff, "请假2"));
        list2.add(new OAItem(R.drawable.libview_oa_mail, "邮件2"));
        list2.add(new OAItem(R.drawable.libview_oa_checkin, "打卡2"));
        list2.add(new OAItem(R.drawable.libview_oa_money, "报销2"));
        list2.add(new OAItem(R.drawable.libview_oa_car, "用车2"));
        list2.add(new OAItem(R.drawable.libview_oa_check, "审批2"));
        oaGroups.add(new OAGroup("财务", list2));
        List<OAItem> list3 = new ArrayList<>();
        list3.add(new OAItem(R.drawable.libview_oa_dayoff, "请假3"));
        list3.add(new OAItem(R.drawable.libview_oa_mail, "邮件3"));
        list3.add(new OAItem(R.drawable.libview_oa_checkin, "打卡3"));
        list3.add(new OAItem(R.drawable.libview_oa_money, "报销3"));
        list3.add(new OAItem(R.drawable.libview_oa_car, "用车3"));
        list3.add(new OAItem(R.drawable.libview_oa_check, "审批3"));
        oaGroups.add(new OAGroup("报销", list3));

        // 2.创建监听器
        OAItemListener oaItemListener = new OAItemListener();

        // 3.初始化view
        // 常用
        oaGroupView_use = new OAGroupLayout(this);
        oaGroupView_use.getTv_oa_title().setText("常用");
        oaGroupView_use.setData(oaGroups_use);
        oaGroupView_use.setItemOnClickListener(oaItemListener);
        oaGroupView_use.showChildHead(false);

        //OA
        oaGroupView = new OAGroupLayout(this);
        oaGroupView.getTv_oa_title().setText("OA");
        oaGroupView.setDividerHeight(50);
        oaGroupView.setData(oaGroups);
        oaGroupView.setItemOnClickListener(oaItemListener);
        oaGroupView.setColumn(4);
        oaGroupView.setDividerHeight(20);

        // 订单
        oaGroupView2 = new OAGroupLayout(this);
        oaGroupView2.getTv_oa_title().setText("订单");
        oaGroupView2.setData(oaGroups);
        oaGroupView2.setItemOnClickListener(oaItemListener);
        oaGroupView2.setColumn(4);


        // 4.添加view
        scrollLinearLayout.addChild(oaGroupView_use);
        scrollLinearLayout.addChild(oaGroupView);
        scrollLinearLayout.addChild(oaGroupView2);

    }

    private void initExpandSplitLayout() {
        expandSplitLayout = new ExpandableSplitLayout(this);
        // 初始化头布局
        View headView = LayoutInflater.from(this).inflate(R.layout.layout_my_head, null, false);
        tv_head_expand = headView.findViewById(R.id.tv_head_expand);
        tv_head_expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandSplitLayout.expandOrCollapse();
                changeStateText();
            }
        });
        expandSplitLayout.setHeadLayout(headView);
        // 初始化内容布局
        View contentView = LayoutInflater.from(this).inflate(R.layout.layout_my_content, null, false);
        TextView tv_content_expand = contentView.findViewById(R.id.tv_content_expand);
        tv_content_expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandSplitLayout.collapse();
                changeStateText();
            }
        });
        expandSplitLayout.setContentView(contentView);

        // 将自定义的expandSplitLayout添加到scrollLinearLayout中
        scrollLinearLayout.addChild(expandSplitLayout);
    }

    public void changeStateText() {
        if (expandSplitLayout.isExpanded()) {
            tv_head_expand.setText("隐藏");
        } else {
            tv_head_expand.setText("显示");
        }
    }

    class OAItemListener implements OAItemRecyclerAdapter.OARecyclerViewItemClickListener {

        @Override
        public void onItemClick(OAItem oaItem) {
            Toast.makeText(TestOAListActivity.this, "点击了->" + oaItem.getOaName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TestOAListActivity.this, TestOADetailActivity.class);
            intent.putExtra("item", oaItem);
            startActivity(intent);
        }
    }
}
