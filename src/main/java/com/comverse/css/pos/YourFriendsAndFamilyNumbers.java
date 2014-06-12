/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.YourFriendsAndFamilyNumbersCommon;

public class YourFriendsAndFamilyNumbers extends YourFriendsAndFamilyNumbersCommon {
    static String expectedScreen = "Your Friends and Family numbers";

    public YourFriendsAndFamilyNumbers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
	public ConfigurationOfYourFriendsAndFamilyNumbers clickReconfigure() throws Exception {
        super.clickReconfigure();
        return new ConfigurationOfYourFriendsAndFamilyNumbers(tool, test, user);
    }

}
