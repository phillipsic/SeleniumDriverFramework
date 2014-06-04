package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateAttachmentCommon extends CommonMenu {

    public CreateAttachmentCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        if (!"Create Attachment".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Create Attachment, but got: " + currentScreen);
        }
    }

    public void addAttachmentName(String attachementName) throws Exception {
        driver.findElement(By.id("name")).sendKeys(attachementName);
    }

    public void addDescription(String description) throws Exception {
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys(description);
    }

    public void uploadAttachment(String locationOfFile) throws Exception {
        String path = System.getProperty("user.dir");
        driver.findElement(By.id("fileUpload")).sendKeys(path + locationOfFile);
    }

    public void clickContinue() throws Exception {
        driver.findElement(By.name("ok")).click();
    }

    public void clickOKFromAddAttachment() throws Exception {
        driver.findElement(By.name("ok")).click();
    }

    public ViewCaseCommon clickOKFromCreateNewAttachmentResult() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewCaseCommon(driver);
    }
}
