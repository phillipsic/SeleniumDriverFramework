package com.comverse.css.pos;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddOutboundCommunicationTemplateCommon;

public class AddOutboundCommunicationTemplate extends AddOutboundCommunicationTemplateCommon {

    public AddOutboundCommunicationTemplate(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Add Outbound Communication Template";

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

        new Select(tool.driver.findElement(By.id("languageCode"))).selectByVisibleText(language);

    }

    public void selectChannel(String channel) throws Exception {

        new Select(tool.driver.findElement(By.id("channel"))).selectByVisibleText(channel);

    }

    public void selectEventType(String eventType) throws Exception {

        new Select(tool.driver.findElement(By.id("eventType"))).selectByVisibleText(eventType);

    }

    public void selectCaseType(String caseType) throws Exception {

        new Select(tool.driver.findElement(By.id("caseType"))).selectByVisibleText(caseType);

    }

    public void selectProblemArea(String problemArea) throws Exception {

        new Select(tool.driver.findElement(By.id("problemArea"))).selectByVisibleText(problemArea);

    }

    public void setDescription(String description) throws Exception {

        tool.driver.findElement(By.id("description")).clear();
        tool.driver.findElement(By.id("description")).sendKeys(description);
    }

    public OutboundCommunicationTemplate clickOK() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new OutboundCommunicationTemplate(tool, test, user);
    }

}
