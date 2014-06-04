package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AdjustBalanceReviewCommon;

public class AdjustBalanceReview extends AdjustBalanceReviewCommon {

    public AdjustBalanceReview(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public AdjustBalanceRequestResult clickConfirm() throws Exception {

        super.clickConfirm();
        return new AdjustBalanceRequestResult(driver);
    }
}
