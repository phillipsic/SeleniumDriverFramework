package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class DeleteBasketConfirmCommon extends CommonMenu {

    public DeleteBasketConfirmCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Delete Basket Confirm";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ResumeAParkedBasketCommon clickOk() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");
        return new ResumeAParkedBasketCommon(tool, test, user);
    }
}
