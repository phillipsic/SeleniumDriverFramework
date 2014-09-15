package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class Tokensfound extends CommonMenu {

    public Tokensfound(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Tokens found";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public UploadToken clickUpload() throws Exception {

        tool.clickUsingXPath("//input[@value='Upload']");

        return new UploadToken(tool, test, user);
    }

}
