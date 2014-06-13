/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

/**
 * 
 * @author gmaroth
 */
public class SendCommunicationCommon extends CommonMenu {
    static String expectedScreen = "Send communication";

    public SendCommunicationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public boolean IsTemplatePresent() throws Exception {
        System.out.println(tool.driver.findElement(By.cssSelector("BODY")).getText());
        if (tool.driver.findElement(By.cssSelector("span")).getText().equals("No templates found.")) {
            System.out.println("Please upload the desired template");
            return false;
        }
        return true;

    }

    public SendCommunicationCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new SendCommunicationCommon(tool, test, user);
    }

    public void clickSearchTemplate() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Search template']")).click();
    }

    public void selectTemplateEventType(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "eventType")).selectByVisibleText(value);

    }

    public void selectTemplateCaseType(String value) throws Exception {

        new Select(tool.searchUsingID(tool, "caseType")).selectByVisibleText(value);
    }

    public void selectTemplateProblemArea(String value) throws Exception {

        new Select(tool.searchUsingID(tool, "problemArea")).selectByVisibleText(value);
    }

    public void selectAvailableCommunicationChannel(String value) throws Exception {

        new Select(tool.searchUsingID(tool, "preferredChannelId")).selectByVisibleText(value);
    }

    public void selectTemplateName(String value) throws Exception {

        new Select(tool.searchUsingID(tool, "templateList")).selectByVisibleText(value);
    }

    public void selectMessageFormat(String value) throws Exception {

        new Select(tool.searchUsingID(tool, "formatList")).selectByVisibleText(value);
    }

    public void clickReviewCommunication() throws Exception {

        tool.driver.findElement(By.name("ok")).click();

    }

    public OutboundCommunicationCommon clickSendCommunication() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Send communication']")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new OutboundCommunicationCommon(tool, test, user);
    }

    public void enterEmailTo(String value) throws Exception {
        tool.driver.findElement(By.id("emailTo")).clear();
        tool.driver.findElement(By.id("emailTo")).sendKeys(value);

    }

    public void clickClosePopUp() throws Exception {

        tool.driver.findElement(By.linkText("Close")).click();

    }
}
