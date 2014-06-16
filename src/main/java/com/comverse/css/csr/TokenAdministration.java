package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class TokenAdministration extends CommonMenu {

    public TokenAdministration(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Token Administration";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public UploadToken clickUpload() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Upload']");

        return new UploadToken(tool, test, user);
    }

}
