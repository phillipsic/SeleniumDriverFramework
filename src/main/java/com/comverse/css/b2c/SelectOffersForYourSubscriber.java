/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author iphilli
 */
public class SelectOffersForYourSubscriber extends B2CMenu {

    public SelectOffersForYourSubscriber(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Select offers for your Subscriber";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectOffersForSubscriber(String... SOTable) throws Exception {

        if (SOTable != null) {
            for (String SOName : SOTable) {

                driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input")).click();
            }
        }

    }

    public ConfigureOffers clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigureOffers(driver);
    }

    public ConfigureBalance clickContinueExpectingConfigurableBalance() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigureBalance(driver);
    }

    public ChooseAccessories clickContinueExpectingChooseAccessories() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ChooseAccessories(driver);
    }

}
