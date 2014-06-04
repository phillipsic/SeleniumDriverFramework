/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;

/**
 * 
 * @author gmaroth
 */
public class SendCommunicationCommon extends CommonMenu {
    static String expectedScreen = "Send communication";

    public SendCommunicationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public boolean IsTemplatePresent() throws Exception {
        System.out.println(driver.findElement(By.cssSelector("BODY")).getText());
        if (driver.findElement(By.cssSelector("span")).getText().equals("No templates found.")) {
            System.out.println("Please upload the desired template");
            return false;
        }
        return true;

    }

    public SendCommunicationCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new SendCommunicationCommon(driver);
    }

    public void clickSearchTemplate() throws Exception {

        driver.findElement(By.xpath("//input[@value='Search template']")).click();
    }

    public void selectTemplateEventType(String value) throws Exception {
        new Select(driver.findElement(By.id("eventType"))).selectByVisibleText(value);

    }

    public void selectTemplateCaseType(String value) throws Exception {

        new Select(driver.findElement(By.id("caseType"))).selectByVisibleText(value);
    }

    public void selectTemplateProblemArea(String value) throws Exception {

        new Select(driver.findElement(By.id("problemArea"))).selectByVisibleText(value);
    }

    public void selectAvailableCommunicationChannel(String value) throws Exception {

        new Select(driver.findElement(By.id("preferredChannelId"))).selectByVisibleText(value);
    }

    public void selectTemplateName(String value) throws Exception {

        new Select(driver.findElement(By.id("templateList"))).selectByVisibleText(value);
    }

    public void selectMessageFormat(String value) throws Exception {

        new Select(driver.findElement(By.id("formatList"))).selectByVisibleText(value);
    }

    public void clickReviewCommunication() throws Exception {

        driver.findElement(By.name("ok")).click();

    }

    public OutboundCommunicationCommon clickSendCommunication() throws Exception {

        driver.findElement(By.xpath("//input[@value='Send communication']")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new OutboundCommunicationCommon(driver);
    }

    public void enterEmailTo(String value) throws Exception {
        driver.findElement(By.id("emailTo")).clear();
        driver.findElement(By.id("emailTo")).sendKeys(value);

    }

    public void clickClosePopUp() throws Exception {

        driver.findElement(By.linkText("Close")).click();

    }
}
