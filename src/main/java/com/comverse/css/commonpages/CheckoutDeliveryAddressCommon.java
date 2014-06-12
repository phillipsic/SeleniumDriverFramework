/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckoutDeliveryAddressCommon extends CommonMenu {

    public CheckoutDeliveryAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Checkout - Delivery Address";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutReviewCommon clickNextPage() throws Exception {
        tool.driver.findElement(By.id("nav_next_page")).click();
        return new CheckoutReviewCommon(tool, test, user);
    }

}
