/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;

public class ConfigureServiceConnectionDetailsCommon extends CommonMenu {
    static String expectedScreen = "Configure Service Connection Details";

    public ConfigureServiceConnectionDetailsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasketCommon(driver);
    }

    public SwapSubscriberExternalIdConfirmationCommon clickContinueExpectingSwapSubscriberExternalIdConfirmation() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SwapSubscriberExternalIdConfirmationCommon(driver);
    }

    public void selectTopLevelContainerType(String containerType) throws Exception {
        new Select(driver.findElement(By.id("p-advInvSearch-L4:17000"))).selectByVisibleText(containerType);
    }

    public ServiceConnectionDetailsCommon clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ServiceConnectionDetailsCommon(driver);
    }

    public void setServiceConnectionEmail(String Email) throws Exception {
        driver.findElement(By.id("inputFields1178")).clear();
        driver.findElement(By.id("inputFields1178")).sendKeys(Email);

    }

}
