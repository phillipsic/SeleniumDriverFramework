package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.UnlockSubscriberConfirmationCommon;

public class UnlockSubscriberConfirmation extends UnlockSubscriberConfirmationCommon {

    public UnlockSubscriberConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public UnlockSubscriberUnlockSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new UnlockSubscriberUnlockSuccessful(driver);
    }
}