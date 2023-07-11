package com.rainstar.demo.spi.java;

import com.rainstar.demo.spi.java.SpiDemoInterface;

/**
 * Created by rainstar on 2023/7/11.
 */
public class StrategyManager {
    private SpiDemoInterface mSpiDemoInterface;

    public StrategyManager(SpiDemoInterface spiDemoInterface) {
        this.mSpiDemoInterface = spiDemoInterface;
    }

    public void displayName(String mode) {
        mSpiDemoInterface.displayName(mode);
    }

    public String getDesc(String mode) {
        return mSpiDemoInterface.getDesc(mode);
    }
}
