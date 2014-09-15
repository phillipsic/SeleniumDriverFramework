package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewPaymentsCommon extends CommonMenu {

    public ViewPaymentsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View Payments";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public void enterFromDate(String fromDate) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("startDate", fromDate);

    }

    public ViewPaymentsCommon clickSearch() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Search'])[3]");
        return new ViewPaymentsCommon(tool, test, user);
    }
}
