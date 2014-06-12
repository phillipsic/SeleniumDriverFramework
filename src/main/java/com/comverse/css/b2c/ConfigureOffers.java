/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureOffers extends B2CMenu {

    public ConfigureOffers(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Configure Offers";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseAccessories clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ChooseAccessories(tool, test, user);
    }

    public ConfigureBalance clickContinueExpectingConfigureBalance() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureBalance(tool, test, user);
    }

    public AddSO clickContinueExpectingOfferConfirmation() throws Exception {
        tool.driver.findElement(By.xpath("//input[@type='submit' and @name='continue_button']")).click();

        return new AddSO(tool, test, user);
    }

    public MyBasket clickContinueExpectingMyBasket() throws Exception {
        tool.driver.findElement(By.xpath("//input[@type='submit' and @name='continue_button']")).click();

        return new MyBasket(tool, test, user);
    }

    public SwapImpact clickContinueExpectingSwapImpact() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SwapImpact(tool, test, user);
    }

}
