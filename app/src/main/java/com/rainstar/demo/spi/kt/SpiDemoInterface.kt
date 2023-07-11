package com.rainstar.demo.spi.kt

/**
 * Created by rainstar on 2023/7/11.
 */
interface SpiDemoInterface {

    fun displayName(mode: String)

    fun getDesc(mode: String): String
}