/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureServiceConnectionDetails extends B2CMenu {

    public ConfigureServiceConnectionDetails(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Configure Service Connection Details";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public void setServiceConnectionEmail(String Email) throws Exception {

        // tool.driver.findElement(By.id("inputFields1180")).clear();
        // tool.driver.findElement(By.id("inputFields1180")).sendKeys(Email);

        tool.driver.findElement(By.xpath(".//span[contains(text(), 'Enter your Email address:')]/../../div[2]/input")).clear();
        tool.driver.findElement(By.xpath(".//span[contains(text(), 'Enter your Email address:')]/../../div[2]/input")).sendKeys(Email);

    }
}
