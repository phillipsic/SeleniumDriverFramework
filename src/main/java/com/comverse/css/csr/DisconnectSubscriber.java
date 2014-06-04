package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.DisconnectSubscriberCommon;

public class DisconnectSubscriber extends DisconnectSubscriberCommon {

    public DisconnectSubscriber(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public DisconnectSubscriberDisconnectionSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new DisconnectSubscriberDisconnectionSuccessful(driver);
    }


}