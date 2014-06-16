/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseAccessories extends B2CMenu {

    public ChooseAccessories(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Choose Accessories";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public ConfigureServiceConnectionDetails clickContinueExpectingConnectionServiceDetails() throws Exception {

        // tool.clickUsingXPath(tool, "//input[@value='Continue']");
        tool.clickUsingName(tool, "doSubmit");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureServiceConnectionDetails(tool, test, user);
    }

    public void setQuantityForAccessory(String Accessory, String Quantity) throws Exception {
        tool.enterStringUsingXPath(tool, ".//a[contains(text(),'" + Accessory + "')]//../preceding-sibling::td[2]//input", Quantity);
    }

}
