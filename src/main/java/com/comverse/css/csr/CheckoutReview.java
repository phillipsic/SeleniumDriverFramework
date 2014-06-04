package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.CheckoutReviewCommon;

public class CheckoutReview extends CheckoutReviewCommon {

    public CheckoutReview(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public CheckoutConfirmation clickConfirm() throws Exception {

        super.clickConfirm();
        return new CheckoutConfirmation(driver);
    }

    @Override
    public ImmediatePayment clickConfirmWithGoods() throws Exception {

        super.clickConfirmWithGoods();
        return new ImmediatePayment(driver);
    }
}
