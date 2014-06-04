package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class SwapSubscriberExternalIdConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Swap Subscriber External Id - Confirmation";

    public SwapSubscriberExternalIdConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberExternalIDSwapDoneCommon clickContinue() throws Exception {
        driver.findElement(By.name("submit")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberExternalIDSwapDoneCommon(driver);
    }

    public void setNewMSISDNInventory(Subscriber subscriber) throws Exception {
        String MSISDN = driver.findElement(By.xpath("//tr[3]/td/span[2]")).getText();
        subscriber.setSubscriberMSISDNProperty(MSISDN);
    }
}