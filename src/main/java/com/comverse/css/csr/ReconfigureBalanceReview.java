package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ReconfigureBalanceReviewCommon;

public class ReconfigureBalanceReview extends ReconfigureBalanceReviewCommon {

    public ReconfigureBalanceReview(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    public ReconfigureBalanceConfirm clickConfirm() throws Exception {

        super.clickConfirm();
        return new ReconfigureBalanceConfirm(driver);
    }

}
