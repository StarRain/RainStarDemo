package com.rainstar.demo.spi.kt

/**
 * Created by rainstar on 2023/7/11.
 */
class StrategyManager(spiDemoInterface: SpiDemoInterface) {
    private var mSpiDemoInterface: SpiDemoInterface

    init {
        mSpiDemoInterface = spiDemoInterface
    }

    fun displayName(mode: String) {
        mSpiDemoInterface.displayName(mode)
    }

    fun getDesc(mode: String): String {
        return mSpiDemoInterface.getDesc(mode)
    }
}