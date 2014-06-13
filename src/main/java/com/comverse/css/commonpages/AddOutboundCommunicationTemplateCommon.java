package com.comverse.css.commonpages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddOutboundCommunicationTemplateCommon extends CommonMenu {
    static String expectedScreen = "Add Outbound Communication Template";

    public AddOutboundCommunicationTemplateCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectTemplate(String filename) throws Exception {

        File file = new File(filename);
        // tool.driver.findElement(By.id("fileUpload")).clear();
        tool.driver.findElement(By.id("templateFile")).sendKeys(file.getAbsolutePath());

    }

    public void selectLanguage(String language) throws Exception {

        new Select(tool.searchUsingID(tool, "languageCode")).selectByVisibleText(language);

    }

    public void selectChannel(String channel) throws Exception {

        new Select(tool.searchUsingID(tool, "channel")).selectByVisibleText(channel);

    }

    public void selectEventType(String eventType) throws Exception {

        new Select(tool.searchUsingID(tool, "eventType")).selectByVisibleText(eventType);

    }

    public void selectCaseType(String caseType) throws Exception {

        new Select(tool.searchUsingID(tool, "caseType")).selectByVisibleText(caseType);

    }

    public void selectProblemArea(String problemArea) throws Exception {

        new Select(tool.searchUsingID(tool, "problemArea")).selectByVisibleText(problemArea);

    }

    public void setDescription(String description) throws Exception {

        tool.driver.findElement(By.id("description")).clear();
        tool.driver.findElement(By.id("description")).sendKeys(description);
    }

    public OutboundCommunicationTemplateCommon clickOK() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new OutboundCommunicationTemplateCommon(tool, test, user);
    }

}
