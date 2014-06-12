package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CreateAttachmentCommon extends CommonMenu {

    public CreateAttachmentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!"Create Attachment".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Create Attachment, but got: " + currentScreen);
        }
    }

    public void addAttachmentName(String attachementName) throws Exception {
        tool.driver.findElement(By.id("name")).sendKeys(attachementName);
    }

    public void addDescription(String description) throws Exception {
        tool.driver.findElement(By.id("description")).clear();
        tool.driver.findElement(By.id("description")).sendKeys(description);
    }

    public void uploadAttachment(String locationOfFile) throws Exception {
        String path = System.getProperty("user.dir");
        tool.driver.findElement(By.id("fileUpload")).sendKeys(path + locationOfFile);
    }

    public void clickContinue() throws Exception {
        tool.driver.findElement(By.name("ok")).click();
    }

    public void clickOKFromAddAttachment() throws Exception {
        tool.driver.findElement(By.name("ok")).click();
    }

    public ViewCaseCommon clickOKFromCreateNewAttachmentResult() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }
}
