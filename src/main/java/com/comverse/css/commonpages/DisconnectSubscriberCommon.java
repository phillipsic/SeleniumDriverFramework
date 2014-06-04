package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class DisconnectSubscriberCommon extends CommonMenu {

    public DisconnectSubscriberCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Disconnect subscriber";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public DisconnectSubscriberDisconnectionSuccessfulCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new DisconnectSubscriberDisconnectionSuccessfulCommon(driver);
    }
}
