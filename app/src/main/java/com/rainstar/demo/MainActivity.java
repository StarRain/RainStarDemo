package com.rainstar.demo;

import android.content.Intent;
import android.view.View;

import com.rainstar.proxy.RainStarProxyService;
import com.rainstar.proxy.toast.IToast;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.spi_demo_java).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.rainstar.demo.spi.java.SpiDemoActivity.class));
            }
        });
        findViewById(R.id.spi_demo_kotlin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.rainstar.demo.spi.kt.SpiDemoActivity.class));
            }
        });
    }

    @Override
    protected void setupView() {
        findViewById(R.id.debug_proxy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RainStarProxyService.getService(IToast.class).showToast("隔离层Toast");
            }
        });
    }

    @Override
    protected String getPageTitle() {
        return "功能演示";
    }
}