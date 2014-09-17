package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CreateAttachmentCommon extends CommonMenu {

    public CreateAttachmentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        if (!"Create Attachment".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Create Attachment, but got: " + currentScreen);
        }
    }

    public void addAttachmentName(String attachementName) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.enterStringUsingId("name", attachementName);
    }

    public void addDescription(String description) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("description", description);
    }

    public void uploadAttachment(String locationOfFile) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String path = System.getProperty("user.dir");
        path = path + locationOfFile;
        tool.enterStringIntoFileUsingName("fileUpload", path);
    }

    public void clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("ok");
    }

    public void clickOKFromAddAttachment() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("ok");
    }

    public ViewCaseCommon clickOKFromCreateNewAttachmentResult() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }
}
