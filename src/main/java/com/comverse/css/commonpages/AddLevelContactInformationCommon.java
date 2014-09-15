package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddLevelContactInformationCommon extends CommonMenu {
    static String expectedScreen = "Add Level - Contact Information";

    public AddLevelContactInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setLevelState(String levelState) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.selectVisibleTextByID("home_state", levelState);
    }

    public void setLevelZipCode(String zipCode) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("home_zip", zipCode);
    }

    public void setLevelName(String levelName) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("company_name", levelName);
    }

    public AddLevelConfirmationCommon clickOk() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        return new AddLevelConfirmationCommon(tool, test, user);
    }
}
