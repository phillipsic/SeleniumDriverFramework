package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.UnlockSubscriberRequestForDetailsCommon;

public class UnlockSubscriberRequestForDetails extends UnlockSubscriberRequestForDetailsCommon {

    public UnlockSubscriberRequestForDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public UnlockSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new UnlockSubscriberConfirmation(driver);
    }
}