package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddCaseConfirmation extends B2CMenu {

    public AddCaseConfirmation(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Add case - confirmation";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddCase clickOk() throws Exception {

        tool.clickUsingCssSelector(tool, "input.submit");
        return new AddCase(tool, test, user);
    }

    public String getCaseID() throws Exception {

        String caseID = tool.getTextUsingXPath(tool, "//span");

        caseID = caseID.replaceAll("[a-zA-Z \\.]", "");
        System.out.println("New Case ID : " + caseID);
        return caseID;
    }
}
