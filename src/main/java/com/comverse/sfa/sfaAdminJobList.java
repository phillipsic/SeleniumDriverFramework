package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.PropertyHelper;

public class sfaAdminJobList extends SFAMenu {

    public sfaAdminJobList(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        if (!tool.checkDisplayedUsingXpath("//div[contains(text(), 'Jobs')]")) {
            throw new IllegalStateException("Expected Jobs screen doesn't show");
        }
    }

    void clickNewJob() throws Exception {
        tool.clickUsingID("Amknfne_label");
        Common.sleepForNumberOfSeconds(1);
    }

    void setJobName(String jobName) throws Exception {
        tool.enterStringUsingId("Ise1y0g", jobName);
    }

    void selectJobType(String jobType) throws Exception {
        tool.selectVisibleTextByID("Ishs3hd", jobType);
        Common.sleepForNumberOfSeconds(1);
    }

    void selectImportMap(String importMap) throws Exception {
        tool.selectVisibleTextByID("Iftqn20", importMap);
    }

    void selectFileEncoding(String fileEncoding) throws Exception {
        tool.selectVisibleTextByID("I7g33k8", fileEncoding);
    }

    void setImportFile(String fileName) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        String leadDirectory = propsHelper.getPasswordProperties("CRMMANAGED.LEADDIR");
        String fileFullPath = leadDirectory + "/" + fileName;
        tool.enterStringUsingId("I6i4zfc", fileFullPath);
    }

    void setRejectDir(String rejectDir) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        String leadDirectory = propsHelper.getPasswordProperties("CRMMANAGED.LEADDIR");
        tool.enterStringUsingId("I52cbz6", leadDirectory + "/" + rejectDir);
    }

    void selectFileHasHeader() throws Exception {
        if (!tool.searchUsingID("Ic5p3o7").isSelected()) {
            tool.clickUsingID("Ic5p3o7");
        }
    }

    void saveJob() throws Exception {
        tool.clickUsingID("Avbojgy_label");
    }

    void selectJobByName(String jobName) throws Exception {
        if (!tool.checkSelectedUsingXpath("//div[contains(text(), '" + jobName + "')]/../../td/input")) {
            tool.clickUsingXPath("//div[contains(text(), '" + jobName + "')]/../../td/input");
        }
        Common.sleepForNumberOfSeconds(1);

    }

    void runJob() throws Exception {
        tool.clickUsingID("A3yirb3_label");
        Common.sleepForNumberOfSeconds(10);
    }

    void deleteJob() throws Exception {
        tool.clickUsingID("Adbgs6e_label");
        Common.sleepForNumberOfSeconds(1);

    }

    void refreshJobList() throws Exception {
        tool.clickUsingID("${id}_refresh");
    }

}
