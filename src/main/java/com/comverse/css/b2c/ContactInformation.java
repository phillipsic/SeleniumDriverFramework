package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ContactInformation extends B2CMenu {

    public ContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Contact Information";

        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

}
