package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class ActionDone extends CommonMenu {

    public ActionDone(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Action Done";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public InsertInventory clickBack() throws Exception {

        tool.clickUsingXPath("//input[@value='Back']");

        return new InsertInventory(tool, test, user);
    }
}
