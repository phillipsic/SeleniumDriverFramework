/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SubscribeToRechargePromotionalOffersCommon extends CommonMenu {
    static String expectedScreen = "Subscribe to recharge promotional offers";

    public SubscribeToRechargePromotionalOffersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectOffersForSubscriber(String RPO) throws Exception {
        
        tool.enterStringUsingId(tool, "nameFilterField0", RPO);
        tool.driver.findElement(By.name("rechargePromotionalOffers")).click();

    }

    public MyBasketCommon clickContinue() throws Exception {

        tool.driver.findElement(By.cssSelector("input[name='rechargePromotionalOffers']")).click();
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(tool, test, user);
    }

}