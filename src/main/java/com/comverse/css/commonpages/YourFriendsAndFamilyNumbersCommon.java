/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class YourFriendsAndFamilyNumbersCommon extends CommonMenu {
    static String expectedScreen = "Your Friends and Family numbers";

    public YourFriendsAndFamilyNumbersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigurationOfYourFriendsAndFamilyNumbersCommon clickReconfigure() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Reconfigure']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigurationOfYourFriendsAndFamilyNumbersCommon(tool, test, user);
    }

    public void verifyPhoneNumber(String phoneNumber) throws Exception {
        Common.assertTextOnPage(tool, phoneNumber);
    }

    public void clickOK() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

}
