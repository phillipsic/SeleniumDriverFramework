package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AccountBundleDistributionConfigurationCommon;

public class AccountBundleDistributionConfiguration extends AccountBundleDistributionConfigurationCommon {

    public AccountBundleDistributionConfiguration(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ConfigureContractDetails clickContinue() throws Exception {
        super.clickContinue();
        return new ConfigureContractDetails(driver);
    }
}