package com.rainstar.demo.spi.kt

import android.view.View
import android.widget.TextView
import com.rainstar.demo.BaseActivity
import com.rainstar.demo.R
import java.util.*

/**
 * Created by rainstar on 2023/7/11.
 */
class SpiDemoActivity : BaseActivity() {
    private lateinit var mStrategyModeDesc: TextView
    private var mServiceLoaderModeDesc: TextView? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_spi_demo
    }

    override fun initView() {
        mStrategyModeDesc = findViewById(R.id.strategy_desc)
        mServiceLoaderModeDesc = findViewById(R.id.service_loader_desc)
    }

    override fun setupView() {
        findViewById<View>(R.id.strategy).setOnClickListener(View.OnClickListener {
            testStrategyMode()
        })
        findViewById<View>(R.id.service_loader).setOnClickListener(View.OnClickListener {
            testServiceLoaderMode()
        })
    }

    override fun getPageTitle(): String {
        return "SPI演示-Kotlin"
    }

    /**
     * 测试策略模式
     */
    private fun testStrategyMode() {
        // 打印日志
        val strategy1 = StrategyManager(SpiDemoInterfaceImpl1())
        strategy1.displayName("策略模式")
        val strategy2 = StrategyManager(SpiDemoInterfaceImpl2())
        strategy2.displayName("策略模式")
        val strategy3 = StrategyManager(SpiDemoInterfaceImpl3())
        strategy3.displayName("策略模式")

        // 页面展示
        mStrategyModeDesc!!.text = String.format("%s\n%s\n%s", strategy1.getDesc("策略模式"), strategy2.getDesc("策略模式"), strategy3.getDesc("策略模式"))
    }

    /**
     * 测试ServiceLoader
     */
    private fun testServiceLoaderMode() {
        val load = ServiceLoader.load(SpiDemoInterface::class.java)
        val iterator: Iterator<SpiDemoInterface> = load.iterator()
        // 页面展示
        val stringBuffer = StringBuffer()
        while (iterator.hasNext()) {
            // 日志打印
            val spiDemoInterface = iterator.next()
            spiDemoInterface.displayName("ServiceLoader")
            // 页面展示
            stringBuffer.append("\n").append(spiDemoInterface.getDesc("ServiceLoader"))
        }
        mServiceLoaderModeDesc!!.text = stringBuffer
    }
}