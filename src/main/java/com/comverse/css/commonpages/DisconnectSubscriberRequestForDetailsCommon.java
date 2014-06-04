package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;

public class DisconnectSubscriberRequestForDetailsCommon extends CommonMenu {
    static String expectedScreen = "Disconnect subscriber - Request for details";

    public DisconnectSubscriberRequestForDetailsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickCheckBoxUnlockNow() throws Exception {

        driver.findElement(By.id("propertyNow")).click();

    }

    public void setReason(String reason) throws Exception {

        new Select(driver.findElement(By.id("reason"))).selectByVisibleText(reason);
    }

    public void setAnnotation(String annotation) throws Exception {

        driver.findElement(By.id("annotation")).clear();
        driver.findElement(By.id("annotation")).sendKeys(annotation);
    }

    public DisconnectSubscriberImpactsCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new DisconnectSubscriberImpactsCommon(driver);
    }
}
