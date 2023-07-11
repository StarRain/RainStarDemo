package com.rainstar.demo.spi.strategy;

import com.rainstar.demo.spi.SpiDemoInterface;

/**
 * Created by rainstar on 2023/7/11.
 */
public class StrategyManager {
    private SpiDemoInterface mSpiDemoInterface;

    public StrategyManager(SpiDemoInterface spiDemoInterface) {
        this.mSpiDemoInterface = spiDemoInterface;
    }

    public void disPlayName(String mode) {
        mSpiDemoInterface.displayImage(mode);
    }

    public String getDesc(String mode) {
        return mSpiDemoInterface.getDesc(mode);
    }
}
