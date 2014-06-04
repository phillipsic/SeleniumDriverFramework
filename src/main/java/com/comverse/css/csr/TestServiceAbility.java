package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.TestServiceAbilityCommon;

public class TestServiceAbility extends TestServiceAbilityCommon {

    public TestServiceAbility(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public Shopping clickOK() throws Exception {
        super.clickOK();
        return new Shopping(driver);
    }
}