package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.FraudlockSubscriberFraudlockSuccessfulCommon;

public class FraudlockSubscriberFraudlockSuccessful extends FraudlockSubscriberFraudlockSuccessfulCommon {

    public FraudlockSubscriberFraudlockSuccessful(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SubscriberDetails clickOK() throws Exception {
        super.clickOK();
        return new SubscriberDetails(driver);
    }
}