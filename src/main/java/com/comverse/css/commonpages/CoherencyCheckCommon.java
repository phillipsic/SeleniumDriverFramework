/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoherencyCheckCommon extends CommonMenu {
    static String expectedScreen = "Coherency Check";

    public CoherencyCheckCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getOrderNumber() throws Exception {
        String orderNumber = driver.findElement(By.xpath("//span")).getText();
        orderNumber = orderNumber.substring(orderNumber.lastIndexOf(" ") + 1);
        return orderNumber;
    }

    public void clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

}
