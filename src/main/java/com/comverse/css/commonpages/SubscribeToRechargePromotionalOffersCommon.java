/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SubscribeToRechargePromotionalOffersCommon extends CommonMenu {
    static String expectedScreen = "Subscribe to recharge promotional offers";

    public SubscribeToRechargePromotionalOffersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void selectOffersForSubscriber(String RPO) throws Exception {
        tool.enterStringUsingId("nameFilterField0", RPO);
        tool.clickUsingName("rechargePromotionalOffers");
    }

    public MyBasketCommon clickContinue() throws Exception {
        tool.clickUsingCssSelector("input[name='rechargePromotionalOffers']");
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

}