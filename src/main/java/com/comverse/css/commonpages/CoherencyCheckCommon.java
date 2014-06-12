/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CoherencyCheckCommon extends CommonMenu {
    static String expectedScreen = "Coherency Check";

    public CoherencyCheckCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getOrderNumber() throws Exception {
        String orderNumber = tool.driver.findElement(By.xpath("//span")).getText();
        orderNumber = orderNumber.substring(orderNumber.lastIndexOf(" ") + 1);
        return orderNumber;
    }

    public void clickOK() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

}
