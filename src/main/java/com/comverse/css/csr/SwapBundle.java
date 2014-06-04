package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SwapBundleCommon;

public class SwapBundle extends SwapBundleCommon {

    public SwapBundle(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AccountBundleDistributionConfiguration clickContinue() throws Exception {
        super.clickContinue();
        return new AccountBundleDistributionConfiguration(driver);
    }

}