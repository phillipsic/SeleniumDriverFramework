package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddSubLevelSelectLevelTypeCommon extends CommonMenu {
    static String expectedScreen = "Add Sub Level - Select Level Type";

    public AddSubLevelSelectLevelTypeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public AddSubLevelLegalAddressCommon clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        return new AddSubLevelLegalAddressCommon(tool, test, user);
    }
}
