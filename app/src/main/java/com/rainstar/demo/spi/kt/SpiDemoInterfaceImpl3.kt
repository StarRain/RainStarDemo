package com.rainstar.demo.spi.kt

import android.util.Log

/**
 * Created by rainstar on 2023/7/11.
 */
class SpiDemoInterfaceImpl3 : SpiDemoInterface {
    private val TAG: String = "SpiDemo-kotlin"

    override fun displayName(mode: String) {
        Log.d(TAG, String.format("%s-%s", mode, this.javaClass.simpleName))
    }

    override fun getDesc(mode: String): String {
        return String.format("%s-%s", mode, this.javaClass.simpleName)
    }

}