package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AdjustBalanceDetailsCommon;

public class AdjustBalanceDetails extends AdjustBalanceDetailsCommon {

    public AdjustBalanceDetails(WebDriver driver) throws Exception {

        super(driver);
    }

    @Override
    public AdjustBalanceReview clickContinue() throws Exception {

        super.clickContinue();
        return new AdjustBalanceReview(driver);
    }
}
