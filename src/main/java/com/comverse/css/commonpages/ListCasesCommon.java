package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ListCasesCommon extends CommonMenu {

    static String expectedScreen = "List Cases";

    public ListCasesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting:" + expectedScreen + ", but got: " + currentScreen);
        }
    }

    public ListCasesCommon clickSearch() throws Exception {

        tool.clickUsingXPath("(//input[@value='Search'])[3]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ListCasesCommon(tool, test, user);
    }

    public ViewCaseCommon clickFirstCase() throws Exception {

        tool.clickUsingXPath("//fieldset/div/table/tbody[2]/tr/td/div/a");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }

    public ViewCaseCommon clickLinkOfCaseID(String caseID) throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingLinkText(caseID);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }
}
