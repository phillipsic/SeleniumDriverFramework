/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class SubscriberIdentifiersSwapCommon extends CommonMenu {
    static String expectedScreen = "Subscriber Identifiers swap";

    public SubscriberIdentifiersSwapCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        if (!expectedScreen.equals(driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureServiceConnectionDetailsCommon clickSwapMSISDNInventory() throws Exception {
        String firstDelimiterString = "MSISDN reference:";
        String secondDelimiterString = "swap_";

        this.clickSwapButton(firstDelimiterString, secondDelimiterString);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigureServiceConnectionDetailsCommon(driver);
    }

    public void clickSwapButton(String firstDelimiterString, String secondDelimiterString) throws Exception {
        String tempString[];
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        String pageSource = driver.getPageSource();

        tempString = pageSource.split(firstDelimiterString);
        tempString = tempString[1].split(secondDelimiterString);
        tempString = tempString[1].split("\"");

        driver.findElement(By.name(secondDelimiterString + tempString[0])).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

}
