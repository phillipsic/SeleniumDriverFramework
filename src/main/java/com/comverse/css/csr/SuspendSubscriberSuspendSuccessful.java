package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SuspendSubscriberSuspendSuccessfulCommon;

public class SuspendSubscriberSuspendSuccessful extends SuspendSubscriberSuspendSuccessfulCommon {

    public SuspendSubscriberSuspendSuccessful(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SubscriberDetails clickOK() throws Exception {
        super.clickOK();
        return new SubscriberDetails(driver);
    }
}