package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewUnbilledMTRCommon extends CommonMenu {

    public ViewUnbilledMTRCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View unbilled MTR";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public ViewUnbilledMTRDetailsCommon clickFirstMTR() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//fieldset/div/table/tbody[2]/tr/td/div/a");
        return new ViewUnbilledMTRDetailsCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Back']");
        return new UnbilledTransactionCommon(tool, test, user);
    }
}
