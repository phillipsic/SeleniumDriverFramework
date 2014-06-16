package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class TokensfoundCommon extends CommonMenu {

    public TokensfoundCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Tokens found";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public UploadTokenCommon clickUpload() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Upload']");

        return new UploadTokenCommon(tool, test, user);
    }

}
