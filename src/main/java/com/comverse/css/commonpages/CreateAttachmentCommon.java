package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CreateAttachmentCommon extends CommonMenu {

    public CreateAttachmentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);

        if (!"Create Attachment".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Create Attachment, but got: " + currentScreen);
        }
    }

    public void addAttachmentName(String attachementName) throws Exception {
        tool.enterStringUsingId(tool, "name", attachementName);
    }

    public void addDescription(String description) throws Exception {
        
        tool.enterStringUsingId(tool, "description", description);
    }

    public void uploadAttachment(String locationOfFile) throws Exception {
        String path = System.getProperty("user.dir");
        tool.enterStringUsingId(tool, "fileUpload", path + locationOfFile);
    }

    public void clickContinue() throws Exception {
        tool.clickUsingName(tool, "ok");
    }

    public void clickOKFromAddAttachment() throws Exception {
        tool.clickUsingName(tool, "ok");
    }

    public ViewCaseCommon clickOKFromCreateNewAttachmentResult() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }
}
