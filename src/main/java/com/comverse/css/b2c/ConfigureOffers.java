/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class ConfigureOffers extends B2CMenu {

    public ConfigureOffers(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Configure Offers";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseAccessories clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ChooseAccessories(driver);
    }

    public ConfigureBalance clickContinueExpectingConfigureBalance() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureBalance(driver);
    }

    public AddSO clickContinueExpectingOfferConfirmation() throws Exception {
        driver.findElement(By.xpath("//input[@type='submit' and @name='continue_button']")).click();

        return new AddSO(driver);
    }

    public MyBasket clickContinueExpectingMyBasket() throws Exception {
        driver.findElement(By.xpath("//input[@type='submit' and @name='continue_button']")).click();

        return new MyBasket(driver);
    }

    public SwapImpact clickContinueExpectingSwapImpact() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SwapImpact(driver);
    }

}
