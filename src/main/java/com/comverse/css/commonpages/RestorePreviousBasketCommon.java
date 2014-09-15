package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RestorePreviousBasketCommon extends CommonMenu {

    public RestorePreviousBasketCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Restore Previous Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public MyBasketCommon clickRestoreSavedBasket() throws Exception {

        tool.clickUsingXPath("//input[@value='Restore the basket']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }
}
