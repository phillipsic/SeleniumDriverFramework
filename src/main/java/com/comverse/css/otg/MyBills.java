package com.comverse.css.otg;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.MyshapeCommon;

public class MyBills extends MyshapeCommon {

    public MyBills(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "billing";
        for (String currentScreenSplitted : currentScreen.split("/")) {
            currentScreen = currentScreenSplitted;
        }

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void verifyMyBills() throws Exception {
        Common.assertTextOnPage(tool, "My Bills");
    }

    public void clickPDFInvoice() throws Exception {
        tool.clickUsingCssSelector(tool, "a > img");
        Thread.sleep(1000);
    }

}
