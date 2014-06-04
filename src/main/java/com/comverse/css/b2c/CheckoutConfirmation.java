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
public class CheckoutConfirmation extends B2CMenu {

    public CheckoutConfirmation(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Checkout Confirmation";


        if (!expectedScreen.equals(this.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchOrders clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SearchOrders(driver);
    }
    
    public Shopping clickOkExpectingShopping() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new Shopping(driver);
    }


    public String getOrderNumberFromPage() throws Exception {
        String orderNumber;

        orderNumber = driver.findElement(By.xpath("//span[2]")).getText();
        System.out.println("Order Number = '" + orderNumber + "'");
        
        return orderNumber;
    }

}
