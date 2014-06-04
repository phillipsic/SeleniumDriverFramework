/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferCancellationCommon extends CommonMenu {

    public OfferCancellationCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Offer Cancellation";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickOk() throws Exception {
        driver.findElement(By.xpath("(//input[@value='OK'])")).click();
        return new AccountDetailsCommon(driver);
    }

    public SubscriberDetailsCommon clickOkGoToSubscriberDashboard() throws Exception {
        driver.findElement(By.xpath("(//input[@value='OK'])")).click();
        return new SubscriberDetailsCommon(driver);
    }
}
