package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.FraudlockSubscriberConfirmationCommon;

public class FraudlockSubscriberConfirmation extends FraudlockSubscriberConfirmationCommon {

    public FraudlockSubscriberConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public FraudlockSubscriberFraudlockSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new FraudlockSubscriberFraudlockSuccessful(driver);
    }
}