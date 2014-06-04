/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class AddAccountOffers extends B2CMenu {

    public AddAccountOffers(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Add Account Offers";

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetail(driver);
    }

    public String getAOOrderNumberFromPage() throws Exception {
        String orderNumber;

        orderNumber = driver.findElement(By.xpath("//div[@class='txt']/span")).getText();
        orderNumber = orderNumber.substring(orderNumber.lastIndexOf(' ') + 1).replace(".", "");
        System.out.println("Order Number = '" + orderNumber + "'");

        return orderNumber;
    }

}
