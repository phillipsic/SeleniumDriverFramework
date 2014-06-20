package com.comverse.css.commonpages;

import java.io.File;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UploadTokenCommon extends CommonMenu {

    public UploadTokenCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Upload Token";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectFile(String filename) throws Exception {

        File file = new File(filename);
        // 
        tool.enterStringUsingId("fileUpload", file.getAbsolutePath());

    }

    public TokensfoundCommon clickOk() throws Exception {

        tool.clickUsingXPath("//input[@value='Ok']");

        return new TokensfoundCommon(tool, test, user);
    }
}
