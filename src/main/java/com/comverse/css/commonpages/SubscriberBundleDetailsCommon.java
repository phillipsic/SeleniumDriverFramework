package com.comverse.css.commonpages;

import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class SubscriberBundleDetailsCommon extends CommonMenu {

    public SubscriberBundleDetailsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Subscriber Bundle Details";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void checkOffer(String SUBSCRIBER_BUNDLE) throws Exception {
        Common.assertTextOnPage(driver, SUBSCRIBER_BUNDLE);
    }
}
