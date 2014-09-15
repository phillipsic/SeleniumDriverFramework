package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ParkTheCurrentBasketCommon extends CommonMenu {

    public ParkTheCurrentBasketCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Park the Current Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void enterBasketID(String value) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("basket", value);
    }

    public void clickOk() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
    }
}
