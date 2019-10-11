package com.dragonforest.app.expandviewgroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dragonforest.app.expandviewgroup.bean.MyOAItem;
import com.dragonforest.app.lib_view.oagroupLayout.bean.OAItem;

public class TestOADetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText ed_contact_us;
    private Button btn_contact_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_oadetail);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        OAItem item = (OAItem) intent.getSerializableExtra("item");
        if (item != null) {
            toolbar.setTitle(item.getOaName());
            Object data = item.getData();
            if (data != null && data instanceof MyOAItem) {
                MyOAItem mitem = (MyOAItem) data;
                String msg = "携带的信息---->\n"
                        + "我的ssid=" + mitem.getSsid() + "\n"
                        + "我的地址=" + mitem.getAddress() + "\n"
                        + "我的电话=" + mitem.getPhone();
                ed_contact_us.setText(msg);
            }
        }
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar acbar = getSupportActionBar();
        if (acbar != null) {
            acbar.setDisplayHomeAsUpEnabled(true);
            acbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        }
        ed_contact_us = findViewById(R.id.ed_contact_us);
        btn_contact_us = findViewById(R.id.btn_contact_us);
        btn_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitContactUs();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void submitContactUs() {
        String content = ed_contact_us.getText().toString().trim();
        if (!"".equals(content)) {
            Toast.makeText(this, "提交已完成", Toast.LENGTH_SHORT).show();
            ed_contact_us.setText("");
        }
    }
}
