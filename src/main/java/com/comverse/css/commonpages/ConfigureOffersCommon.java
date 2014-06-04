/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureOffersCommon extends CommonMenu {

    public ConfigureOffersCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Configure Offers";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureBalanceCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureBalanceCommon(driver);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(driver);
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ServiceConnectionDetailsCommon(driver);
    }

    public SwapImpactCommon clickContinueExpectingSwapImpact() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SwapImpactCommon(driver);
    }

}
