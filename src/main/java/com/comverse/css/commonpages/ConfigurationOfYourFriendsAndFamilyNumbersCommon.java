/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigurationOfYourFriendsAndFamilyNumbersCommon extends CommonMenu {

    public ConfigurationOfYourFriendsAndFamilyNumbersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!"Configuration of your Friends and Family numbers".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Subscriber Details, but got: " + currentScreen);

        }
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        
        tool.enterStringUsingName("friendsAndFamilyListInputFieldsphone_number0", phoneNumber);
    }

    public void clickOK() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
    }

}
