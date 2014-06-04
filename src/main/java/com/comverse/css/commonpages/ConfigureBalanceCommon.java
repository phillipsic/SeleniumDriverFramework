/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureBalanceCommon extends CommonMenu {

    public ConfigureBalanceCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Configure Balance";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        this.clickContinue();
        return new ServiceConnectionDetailsCommon(driver);
    }

    public ConfigureContractDetailsCommon clickContinueExpectingConfigureContractDetails() throws Exception {
        this.clickContinue();
        return new ConfigureContractDetailsCommon(driver);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {
        this.clickContinue();
        return new MyBasketCommon(driver);
    }

    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {
        driver.findElement(By.id(limitName + "_limit")).clear();
        driver.findElement(By.id(limitName + "_limit")).sendKeys(limitAmount);
    }

    public void clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
    }
}
