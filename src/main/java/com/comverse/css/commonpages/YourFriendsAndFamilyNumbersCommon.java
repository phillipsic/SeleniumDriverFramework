/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class YourFriendsAndFamilyNumbersCommon extends CommonMenu {
    static String expectedScreen = "Your Friends and Family numbers";

    public YourFriendsAndFamilyNumbersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public ConfigurationOfYourFriendsAndFamilyNumbersCommon clickReconfigure() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Reconfigure']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigurationOfYourFriendsAndFamilyNumbersCommon(tool, test, user);
    }

    public void verifyPhoneNumber(String phoneNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        Common.assertTextOnPage(tool, phoneNumber);
    }

    public void clickOK() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
    }

}
