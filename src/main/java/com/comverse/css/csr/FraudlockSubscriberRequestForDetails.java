package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.FraudlockSubscriberRequestForDetailsCommon;

public class FraudlockSubscriberRequestForDetails extends FraudlockSubscriberRequestForDetailsCommon {

    public FraudlockSubscriberRequestForDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public FraudlockSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new FraudlockSubscriberConfirmation(driver);
    }
}