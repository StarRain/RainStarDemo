package com.rainstar.demo.asm;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rainstar.demo.BaseActivity;
import com.rainstar.demo.R;

/**
 * Created by rainstar on 2023/7/13.
 */
public class ASMTestActivity extends BaseActivity {
    private Button mTestASM;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_asm_test;
    }

    @Override
    protected void initView() {
        mTestASM = findViewById(R.id.test_asm);
    }

    @Override
    protected void setupView() {
        mTestASM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testAsmAddToast();
            }
        });
    }

    @Override
    protected String getPageTitle() {
        return "测试ASM功能";
    }

    /**
     * 此方法为调试目标方法
     */
    private void testAsmAddToast() {
    }
}
