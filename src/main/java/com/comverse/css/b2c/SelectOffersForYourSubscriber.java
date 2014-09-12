/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SelectOffersForYourSubscriber extends B2CMenu {

    public SelectOffersForYourSubscriber(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Select offers for your Subscriber";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("Expecting: " + expectedScreen + " , but got: " + currentScreen);
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        test.writeInLog(" >>>Now on: " + expectedScreen + "<<<");
    }

    public void selectOffersForSubscriber(String... SOTable) throws Exception {

        if (SOTable != null) {
            for (String SOName : SOTable) {

                tool.clickUsingXPath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input");
            }
        }

    }

    public ConfigureOffers clickContinue() throws Exception {
        test.writeInLog(this.getClass().getSimpleName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureOffers(tool, test, user);
    }

    public ConfigureBalance clickContinueExpectingConfigurableBalance() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureBalance(tool, test, user);
    }

    public ChooseAccessories clickContinueExpectingChooseAccessories() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseAccessories(tool, test, user);
    }

}
