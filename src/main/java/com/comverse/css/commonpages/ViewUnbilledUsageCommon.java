package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewUnbilledUsageCommon extends CommonMenu {

    public ViewUnbilledUsageCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View unbilled usage";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public void enterToDate(String toDate) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("toDate", toDate);

    }

    public void enterFromDate(String fromDate) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("fromDate", fromDate);

    }

    public ViewUnbilledUsageCommon clickSearch() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Search'])[3]");
        return new ViewUnbilledUsageCommon(tool, test, user);
    }

    public ViewUnbilledUsageDetailsCommon clickFirstUsage() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("usageDetails");
        return new ViewUnbilledUsageDetailsCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Back']");
        return new UnbilledTransactionCommon(tool, test, user);
    }
}
