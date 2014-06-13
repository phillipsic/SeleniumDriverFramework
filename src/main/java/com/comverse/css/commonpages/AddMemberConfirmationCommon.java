package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddMemberConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Add Member - Confirmation";

    public AddMemberConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddMemberCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

        return new AddMemberCommon(tool, test, user);
    }
}
