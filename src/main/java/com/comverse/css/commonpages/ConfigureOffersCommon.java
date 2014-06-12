/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureOffersCommon extends CommonMenu {

    public ConfigureOffersCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Configure Offers";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureBalanceCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureBalanceCommon(tool, test, user);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public SwapImpactCommon clickContinueExpectingSwapImpact() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SwapImpactCommon(tool, test, user);
    }

}
