/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckOutDeliveryAddress extends B2CMenu {

    public CheckOutDeliveryAddress(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Checkout - Delivery Address";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckOutBillingAccountInformation clickContinue() throws Exception {

        tool.driver.findElement(By.id("nav_next_page")).click();
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

}
