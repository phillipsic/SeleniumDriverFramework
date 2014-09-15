package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddCaseConfirmation extends B2CMenu {

    public AddCaseConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add case - confirmation";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public AddCase clickOk() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingCssSelector("input.submit");
        return new AddCase(tool, test, user);
    }

    public String getCaseID() throws Exception {
        test.writeInLog(Common.getMethodName());
        String caseID = tool.getTextUsingXPath("//span");

        caseID = caseID.replaceAll("[a-zA-Z \\.]", "");
        System.out.println("New Case ID : " + caseID);
        return caseID;
    }
}
