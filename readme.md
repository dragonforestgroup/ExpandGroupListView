# UI套件
* 轻松实现高效复杂的伸缩列表

## ExpandableLayout: 可伸缩的布局
* * 感谢 https://github.com/cachapa/ExpandableLayout  
* 效果：<br>
   ![image](https://github.com/dragonforestgroup/ExpandGroupListView/tree/master/lib_view/images/expandable.gif)
   
## OAGroupView: 可伸缩的列表展示View
* 效果：<br>
   ![image](https://github.com/dragonforestgroup/ExpandGroupListView/tree/master/lib_view/images/oagroup.gif)
* 使用：<br>
   ```
    // ===构建数据集合
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
     
    //===构建View   
    oaGroupView_use=new OAGroupView(this);
    // 设置标题
    oaGroupView_use.getTv_oa_title().setText("OA");
    // 设置内部间隔，需要在setData()之前调用
    oaGroupView_use.setDividerHeight(50);
    // 设置内部数据
    oaGroupView_use.setData(oaGroups);
    // 设置子项监听事件
    oaGroupView_use.setItemOnClickListener(oaItemListener);
    // 设置是否显示子view的标题（默认显示）
    oaGroupView_use.showChildHead(false);
    // 设置列表的列数
    oaGroupView_use.setColumn(4);
   ``` 
   通过动态布局不要忘记通过addView添加进所在的根布局中！
      
## ScrollLinearLayout: 可滑动的线性布局
* 支持添加多个子view,可结合OAGroupView使用
* 使用：<br>
    布局文件：
   ```
    <com.dragonforest.app.lib_view.scrolllinearlayout.ScrollLinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/scrollLinearLayout"></com.dragonforest.app.lib_view.scrolllinearlayout.ScrollLinearLayout>
   ```
   
   代码中：
   ```
   scrollLinearLayout.addChild(oaGroupView1);
   scrollLinearLayout.addChild(oaGroupView2);
   scrollLinearLayout.addChild(oaGroupView3);
   ```
   
# View组合关系：

   * ![image](https://github.com/dragonforestgroup/ExpandGroupListView/tree/master/lib_view/images/jiegou.png)



