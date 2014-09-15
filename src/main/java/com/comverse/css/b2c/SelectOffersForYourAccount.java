/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SelectOffersForYourAccount extends B2CMenu {

    public SelectOffersForYourAccount(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Select offers for your Account";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void selectOffersForAccount(String... SOTable) throws Exception {

        if (SOTable != null) {
            for (String SOName : SOTable) {

                tool.clickUsingXPath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input");
            }
        }

    }

    public EnterYourSubscriptionDetails clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public AddAccountOffers clickContinueToAddAO() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddAccountOffers(tool, test, user);
    }

}
