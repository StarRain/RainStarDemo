package com.rainstar.demo.spi.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rainstar.demo.BaseActivity;
import com.rainstar.demo.R;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by rainstar on 2023/7/11.
 */
public class SpiDemoActivity extends BaseActivity {
    private TextView mStrategyModeDesc;
    private TextView mServiceLoaderModeDesc;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_spi_demo;
    }

    @Override
    protected void initView() {
        mStrategyModeDesc = findViewById(R.id.strategy_desc);
        mServiceLoaderModeDesc = findViewById(R.id.service_loader_desc);
    }

    @Override
    protected void setupView() {
        findViewById(R.id.strategy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testStrategyMode();
            }
        });

        findViewById(R.id.service_loader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testServiceLoaderMode();
            }
        });
    }

    @Override
    protected String getPageTitle() {
        return "SPI演示-Java";
    }

    /**
     * 测试策略模式
     */
    private void testStrategyMode() {
        // 打印日志
        StrategyManager strategy1 = new StrategyManager(new SpiDemoInterfaceImpl1());
        strategy1.displayName("策略模式");

        StrategyManager strategy2 = new StrategyManager(new SpiDemoInterfaceImpl2());
        strategy2.displayName("策略模式");

        StrategyManager strategy3 = new StrategyManager(new SpiDemoInterfaceImpl3());
        strategy3.displayName("策略模式");

        // 页面展示
        mStrategyModeDesc.setText(String.format("%s\n%s\n%s", strategy1.getDesc("策略模式"), strategy2.getDesc("策略模式"), strategy3.getDesc("策略模式")));
    }

    /**
     * 测试ServiceLoader
     */
    private void testServiceLoaderMode() {
        ServiceLoader<SpiDemoInterface> load = ServiceLoader.load(SpiDemoInterface.class);
        Iterator<SpiDemoInterface> iterator = load.iterator();
        // 页面展示
        StringBuffer stringBuffer = new StringBuffer();
        while (iterator.hasNext()) {
            // 日志打印
            SpiDemoInterface spiDemoInterface = iterator.next();
            spiDemoInterface.displayName("ServiceLoader");
            // 页面展示
            stringBuffer.append("\n").append(spiDemoInterface.getDesc("ServiceLoader"));
        }
        mServiceLoaderModeDesc.setText(stringBuffer);
    }
}
