/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscribeToRechargePromotionalOffersCommon extends CommonMenu {
    static String expectedScreen = "Subscribe to recharge promotional offers";

    public SubscribeToRechargePromotionalOffersCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectOffersForSubscriber(String RPO) throws Exception {
        driver.findElement(By.id("nameFilterField0")).clear();
        driver.findElement(By.id("nameFilterField0")).sendKeys(RPO);
        driver.findElement(By.name("rechargePromotionalOffers")).click();

    }

    public MyBasketCommon clickContinue() throws Exception {

        driver.findElement(By.cssSelector("input[name='rechargePromotionalOffers']")).click();
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(driver);
    }

}