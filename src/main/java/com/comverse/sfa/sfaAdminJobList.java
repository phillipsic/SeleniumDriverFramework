package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.PropertyHelper;

public class sfaAdminJobList extends SFAMenu {

    public sfaAdminJobList(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        if (!tool.checkDisplayedUsingXpath(tool, "//div[contains(text(), 'Jobs')]")) {
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
        tool.selectVisibleTextByID(tool, "Ishs3hd", jobType);
        Common.sleepForNumberOfSeconds(1);
    }

    void selectImportMap(String importMap) throws Exception {
        tool.selectVisibleTextByID(tool, "Iftqn20", importMap);
    }

    void selectFileEncoding(String fileEncoding) throws Exception {
        tool.selectVisibleTextByID(tool, "I7g33k8", fileEncoding);
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
        if (!tool.checkSelectedUsingXpath(tool, "//div[contains(text(), '" + jobName + "')]/../../td/input")) {
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
