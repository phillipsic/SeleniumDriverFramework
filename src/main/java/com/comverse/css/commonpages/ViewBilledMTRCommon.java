package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewBilledMTRCommon extends CommonMenu {

    public ViewBilledMTRCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View billed MTR";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewBilledMTRDetailsCommon clickFirstMTR() throws Exception {

        tool.clickUsingXPath(tool, "//fieldset/div/table/tbody[2]/tr/td/div/a");
        return new ViewBilledMTRDetailsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickBack() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }
}
