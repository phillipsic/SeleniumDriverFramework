package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.DisconnectSubscriberImpactsCommon;

public class DisconnectSubscriberImpacts extends DisconnectSubscriberImpactsCommon {

    public DisconnectSubscriberImpacts(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public DisconnectSubscriber clickConfirm() throws Exception {
        super.clickConfirm();
        return new DisconnectSubscriber(driver);
    }
}