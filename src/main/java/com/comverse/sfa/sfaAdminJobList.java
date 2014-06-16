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
        tool.clickUsingID(tool, "Amknfne_label");
        Common.sleepForNumberOfSeconds(1);
    }

    void setJobName(String jobName) throws Exception {
        tool.enterStringUsingId(tool, "Ise1y0g", jobName);
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

    void setImportFile(String fileName) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        String leadDirectory = propsHelper.getPasswordProperties("CRMMANAGED.LEADDIR");
        String fileFullPath = leadDirectory + "/" + fileName;
        tool.enterStringUsingId(tool, "I6i4zfc", fileFullPath);
    }

    void setRejectDir(String rejectDir) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        String leadDirectory = propsHelper.getPasswordProperties("CRMMANAGED.LEADDIR");
        tool.enterStringUsingId(tool, "I52cbz6", leadDirectory + "/" + rejectDir);
    }

    void selectFileHasHeader() throws Exception {
        if (!tool.searchUsingID(tool, "Ic5p3o7").isSelected()) {
            tool.clickUsingID(tool, "Ic5p3o7");
        }
    }

    void saveJob() throws Exception {
        tool.clickUsingID(tool, "Avbojgy_label");
    }

    void selectJobByName(String jobName) throws Exception {
        if (!tool.driver.findElement(By.xpath("//div[contains(text(), '" + jobName + "')]/../../td/input")).isSelected()) {
            tool.clickUsingXPath(tool, "//div[contains(text(), '" + jobName + "')]/../../td/input");
        }
        Common.sleepForNumberOfSeconds(1);

    }

    void runJob() throws Exception {
        tool.clickUsingID(tool, "A3yirb3_label");
        Common.sleepForNumberOfSeconds(10);
    }

    void deleteJob() throws Exception {
        tool.clickUsingID(tool, "Adbgs6e_label");
        Common.sleepForNumberOfSeconds(1);

    }

    void refreshJobList() throws Exception {
        tool.clickUsingID(tool, "${id}_refresh");
    }

}
