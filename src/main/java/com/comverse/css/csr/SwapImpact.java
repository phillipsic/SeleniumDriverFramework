package com.comverse.css.csr;

import com.comverse.css.commonpages.SwapImpactCommon;
import org.openqa.selenium.WebDriver;

public class SwapImpact extends SwapImpactCommon {

    public SwapImpact(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public MyBasket clickOK() throws Exception {
        super.clickOK();
        return new MyBasket(driver);
    }

    @Override
    public ConfigureBalance clickOKExpectingConfigureBalance() throws Exception {
        super.clickOKExpectingConfigureBalance();
        return new ConfigureBalance(driver);
    }
}
