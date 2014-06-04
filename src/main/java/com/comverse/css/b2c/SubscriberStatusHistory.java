package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Koushic
 */
public class SubscriberStatusHistory extends B2CMenu {

    public SubscriberStatusHistory(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Subscriber Status History";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        // Common.waitForEndOfWaitingPage(driver,
        // this.getClass().getSimpleName());
        return new SubscriberDetail(driver);
    }

    public String getStatus() throws Exception {
        String subscriberStatus;
        subscriberStatus = driver.findElement(By.xpath("//td[2]")).getText();
        return subscriberStatus;

    }

}
