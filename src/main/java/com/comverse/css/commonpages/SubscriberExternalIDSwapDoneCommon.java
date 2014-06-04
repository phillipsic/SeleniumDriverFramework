package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class SubscriberExternalIDSwapDoneCommon extends CommonMenu {
    static String expectedScreen = "Subscriber External ID Swap - Done";

    public SubscriberExternalIDSwapDoneCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetailsCommon clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(driver);
    }
}