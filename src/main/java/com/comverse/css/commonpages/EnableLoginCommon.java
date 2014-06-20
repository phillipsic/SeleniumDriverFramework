package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class EnableLoginCommon extends CommonMenu {

    public EnableLoginCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        if (!"Enable Login".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Enable Login, but got: " + currentScreen);
        }
    }

    public LoginInformationCommon clickOk() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
        return new LoginInformationCommon(tool, test, user);
    }
}
