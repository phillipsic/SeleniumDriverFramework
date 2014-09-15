package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewBilledRCNRCTermsCommon extends CommonMenu {

    public ViewBilledRCNRCTermsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View billed RC/NRC terms";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public ViewBilledRCNRCTermDetailsCommon clickFirstRCTerm() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//fieldset/div[4]/div/table/tbody[2]/tr/td/div/a");
        return new ViewBilledRCNRCTermDetailsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Back']");
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }
}
