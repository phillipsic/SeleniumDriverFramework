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
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Select offers for your Account";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectOffersForAccount(String... SOTable) throws Exception {

        if (SOTable != null) {
            for (String SOName : SOTable) {

                tool.clickUsingXPath(tool, "//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input");
            }
        }

    }

    public EnterYourSubscriptionDetails clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public AddAccountOffers clickContinueToAddAO() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddAccountOffers(tool, test, user);
    }

}
