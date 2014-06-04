package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class FraudlockSubscriberConfirmationCommon extends CommonMenu {

    public FraudlockSubscriberConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Fraud lock subscriber - Confirmation";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public FraudlockSubscriberFraudlockSuccessfulCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new FraudlockSubscriberFraudlockSuccessfulCommon(driver);
    }
}
