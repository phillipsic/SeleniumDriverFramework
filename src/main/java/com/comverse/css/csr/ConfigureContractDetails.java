package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ConfigureContractDetailsCommon;

public class ConfigureContractDetails extends ConfigureContractDetailsCommon {

    public ConfigureContractDetails(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MyBasket clickContinue() throws Exception {

        super.clickContinue();
        return new MyBasket(driver);
    }

    @Override
    public ConfigureBalance clickContinueExpectingConfigureBalance() throws Exception {
        super.clickContinueExpectingConfigureBalance();
        return new ConfigureBalance(driver);
    }
}
