package com.comverse.css.csr;

import java.io.File;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class UploadToken extends CommonMenu {

    public UploadToken(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Upload Token";

        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectFile(String filename) throws Exception {
        File file = new File(filename);

        tool.enterStringUsingId(tool, "fileUpload", file.getAbsolutePath());
    }

    public TokenAdministration clickOk() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Ok']");

        return new TokenAdministration(tool, test, user);
    }
}
