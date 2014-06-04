package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.UnlockSubscriberUnlockSuccessfulCommon;

public class UnlockSubscriberUnlockSuccessful extends UnlockSubscriberUnlockSuccessfulCommon {

    public UnlockSubscriberUnlockSuccessful(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SubscriberDetails clickOK() throws Exception {
        super.clickOK();
        return new SubscriberDetails(driver);
    }
}