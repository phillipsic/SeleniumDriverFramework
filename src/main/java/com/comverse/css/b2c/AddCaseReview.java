package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddCaseReview extends B2CMenu {

    public AddCaseReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Add case - review";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddCaseConfirmation clickCreateCase() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Create case']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddCaseConfirmation(tool, test, user);
    }
}
