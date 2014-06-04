package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SuspendSubscriberConfirmationCommon;

public class SuspendSubscriberConfirmation extends SuspendSubscriberConfirmationCommon {

    public SuspendSubscriberConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SuspendSubscriberSuspendSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new SuspendSubscriberSuspendSuccessful(driver);
    }
}