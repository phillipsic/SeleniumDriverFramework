package com.comverse.css.commonpages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddOutboundCommunicationTemplateCommon {
    static String expectedScreen = "Add Outbound Communication Template";
    public WebDriver driver;

    public AddOutboundCommunicationTemplateCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectTemplate(String filename) throws Exception {

        File file = new File(filename);
        // driver.findElement(By.id("fileUpload")).clear();
        driver.findElement(By.id("templateFile")).sendKeys(file.getAbsolutePath());

    }

    public void selectLanguage(String language) throws Exception {

        new Select(driver.findElement(By.id("languageCode"))).selectByVisibleText(language);

    }

    public void selectChannel(String channel) throws Exception {

        new Select(driver.findElement(By.id("channel"))).selectByVisibleText(channel);

    }

    public void selectEventType(String eventType) throws Exception {

        new Select(driver.findElement(By.id("eventType"))).selectByVisibleText(eventType);

    }

    public void selectCaseType(String caseType) throws Exception {

        new Select(driver.findElement(By.id("caseType"))).selectByVisibleText(caseType);

    }

    public void selectProblemArea(String problemArea) throws Exception {

        new Select(driver.findElement(By.id("problemArea"))).selectByVisibleText(problemArea);

    }

    public void setDescription(String description) throws Exception {

        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys(description);
    }

    public OutboundCommunicationTemplateCommon clickOK() throws Exception {

        driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new OutboundCommunicationTemplateCommon(driver);
    }

}
