package com.dragonforest.app.lib_view.scrolllinearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dragonforest.app.lib_view.R;

/**
 * @author 韩龙林
 * @date 2019/10/11 11:48
 */
public class ScrollLinearLayout extends LinearLayout {
    LinearLayout contentLayout;
    public ScrollLinearLayout(Context context) {
        super(context);
        initView(context);
    }

    public ScrollLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.libview_scrolllinearlayout,this);
        contentLayout=findViewById(R.id.contentLayout);
    }

    public void addChild(View v){
        LinearLayout.LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        contentLayout.addView(v);
    }
}
