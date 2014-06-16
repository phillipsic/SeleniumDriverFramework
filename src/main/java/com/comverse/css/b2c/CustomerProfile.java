package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CustomerProfile extends B2CMenu {

    public CustomerProfile(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Customer Profile";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyProfileInformation clickModify() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Modify']");
        return new ModifyProfileInformation(tool, test, user);
    }

}
