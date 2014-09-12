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
        String currentScreen = tool.getTitle();
        String expectedScreen = "Choose Accessories";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("Expecting: " + expectedScreen + " , but got: " + currentScreen);
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        test.writeInLog(this.getClass().getSimpleName());
    }

    public MyBasket clickContinue() throws Exception {
        test.writeInLog(this.getClass().getSimpleName());
        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public ConfigureServiceConnectionDetails clickContinueExpectingConnectionServiceDetails() throws Exception {

        // tool.clickUsingXPath("//input[@value='Continue']");
        tool.clickUsingName("doSubmit");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureServiceConnectionDetails(tool, test, user);
    }

    public void setQuantityForAccessory(String Accessory, String Quantity) throws Exception {
        tool.enterStringUsingXPath(".//a[contains(text(),'" + Accessory + "')]//../preceding-sibling::td[2]//input", Quantity);
    }

}
