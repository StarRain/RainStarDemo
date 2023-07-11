package com.rainstar.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rainstar on 2023/7/11.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Context mContext;
    protected Activity mActivity;

    private TextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        init();
        initStatusBar();
        initTitleBar();
        addContentView();
        initView();
        setupView();
    }

    private void initStatusBar() {

    }

    private void init() {
        mContext = this;
        mActivity = this;
    }

    private void initTitleBar() {
        mTitle = findViewById(R.id.title_content);
        String pageTitle = getPageTitle();
        if (TextUtils.isEmpty(pageTitle)) {
            mTitle.setText(getClass().getSimpleName());
        } else {
            mTitle.setText(pageTitle);
        }
        findViewById(R.id.title_back_button).setOnClickListener(this);
        findViewById(R.id.title_setting_button).setOnClickListener(this);
    }

    private void addContentView() {
        FrameLayout container = findViewById(R.id.base_content_conatiner);
        View contentView = getLayoutInflater().inflate(getLayoutId(), null, false);
        container.addView(contentView);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.title_back_button) {
            clickBack();
        } else if (id == R.id.title_setting_button) {
            clickSetting();
        } else {
            click(v);
        }
    }

    protected void clickBack() {
        onBackPressed();
    }

    protected void clickSetting() {
        Toast.makeText(mContext, "设置", Toast.LENGTH_SHORT).show();
    }

    protected void click(View view) {

    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void setupView();

    protected abstract String getPageTitle();
}
