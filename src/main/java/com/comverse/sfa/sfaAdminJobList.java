package com.comverse.sfa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.PropertyHelper;

public class sfaAdminJobList extends SFAMenu {

    public sfaAdminJobList(AutomationTool tool, Test test, User user) {
        super(tool, test, user);

        if (!tool.driver.findElement(By.xpath("//div[contains(text(), 'Jobs')]")).isDisplayed()) {
            throw new IllegalStateException("Expected Jobs screen doesn't show");

        }
    }

    void clickNewJob() throws Exception {
        tool.driver.findElement(By.id("Amknfne_label")).click();
        Common.sleepForNumberOfSeconds(1);
    }

    void setJobName(String jobName) {
        tool.driver.findElement(By.id("Ise1y0g")).sendKeys(jobName);
    }

    void selectJobType(String jobType) throws Exception {
        new Select(tool.searchUsingID(tool, "Ishs3hd")).selectByVisibleText(jobType);
        Common.sleepForNumberOfSeconds(1);
    }

    void selectImportMap(String importMap) throws Exception {
        new Select(tool.searchUsingID(tool, "Iftqn20")).selectByVisibleText(importMap);
    }

    void selectFileEncoding(String fileEncoding) throws Exception {
        new Select(tool.searchUsingID(tool, "I7g33k8")).selectByVisibleText(fileEncoding);
    }

    void setImportFile(String fileName) {
        PropertyHelper propsHelper = new PropertyHelper();
        String leadDirectory = propsHelper.getPasswordProperties("CRMMANAGED.LEADDIR");
        String fileFullPath = leadDirectory + "/" + fileName;
        tool.driver.findElement(By.id("I6i4zfc")).sendKeys(fileFullPath);
    }

    void setRejectDir(String rejectDir) {
        PropertyHelper propsHelper = new PropertyHelper();
        String leadDirectory = propsHelper.getPasswordProperties("CRMMANAGED.LEADDIR");
        tool.driver.findElement(By.id("I52cbz6")).sendKeys(leadDirectory + "/" + rejectDir);
    }

    void selectFileHasHeader() {
        if (!driver.findElement(By.id("Ic5p3o7")).isSelected()) {
            tool.driver.findElement(By.id("Ic5p3o7")).click();
        }
    }

    void saveJob() {
        tool.driver.findElement(By.id("Avbojgy_label")).click();
    }

    void selectJobByName(String jobName) throws Exception {
        if (!driver.findElement(By.xpath("//div[contains(text(), '" + jobName + "')]/../../td/input")).isSelected()) {
            tool.driver.findElement(By.xpath("//div[contains(text(), '" + jobName + "')]/../../td/input")).click();
        }
        Common.sleepForNumberOfSeconds(1);

    }

    void runJob() throws Exception {
        tool.driver.findElement(By.id("A3yirb3_label")).click();
        Common.sleepForNumberOfSeconds(10);
    }

    void deleteJob() throws Exception {
        tool.driver.findElement(By.id("Adbgs6e_label")).click();
        Common.sleepForNumberOfSeconds(1);

    }

    void refreshJobList() {
        tool.driver.findElement(By.id("${id}_refresh")).click();
    }

}
