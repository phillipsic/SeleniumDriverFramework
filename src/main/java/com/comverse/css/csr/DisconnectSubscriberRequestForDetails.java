package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.DisconnectSubscriberRequestForDetailsCommon;

public class DisconnectSubscriberRequestForDetails extends DisconnectSubscriberRequestForDetailsCommon {

    public DisconnectSubscriberRequestForDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public DisconnectSubscriberImpacts clickContinue() throws Exception {
        super.clickContinue();
        return new DisconnectSubscriberImpacts(driver);
    }
}