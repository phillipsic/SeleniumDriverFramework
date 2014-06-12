/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseAccessories extends B2CMenu {

    public ChooseAccessories(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Choose Accessories";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public ConfigureServiceConnectionDetails clickContinueExpectingConnectionServiceDetails() throws Exception {

        // tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        tool.driver.findElement(By.name("doSubmit")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureServiceConnectionDetails(tool, test, user);
    }

    public void setQuantityForAccessory(String Accessory, String Quantity) throws Exception {
        WebElement quantityInputText = tool.driver.findElement(By.xpath(".//a[contains(text(),'" + Accessory + "')]//../preceding-sibling::td[2]//input"));
        quantityInputText.clear();
        quantityInputText.sendKeys(Quantity);

    }

}
