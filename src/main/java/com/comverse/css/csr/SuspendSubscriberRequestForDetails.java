package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SuspendSubscriberRequestForDetailsCommon;

public class SuspendSubscriberRequestForDetails extends SuspendSubscriberRequestForDetailsCommon {

    public SuspendSubscriberRequestForDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SuspendSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new SuspendSubscriberConfirmation(driver);
    }
}