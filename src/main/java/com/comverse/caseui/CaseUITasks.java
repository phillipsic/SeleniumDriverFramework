package com.comverse.caseui;

import com.comverse.caseui.common.CaseUITest;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CaseUITasks extends CaseUITest {

    public CaseUITasks(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickNewTask() throws Exception {
        tool.clickUsingID(tool, "Alhzdry_label");
        Thread.sleep(3000);
    }

    public void clickSearchAccount(String mainWindow) throws Exception {
        tool.clickUsingID(tool, "Ifhjkr4_img");
        Thread.sleep(3000);
        Common.switchToNewWindow(tool, mainWindow);
    }

    public void clickSearch(String accountLastname) throws Exception {
        tool.enterStringUsingId(tool, "Ilgmxak", "%" + accountLastname);
        tool.clickUsingID(tool, "$as73pr_filterbutton");
        Thread.sleep(3000);
    }

    public void selectFirstAccount(String mainWindow) throws Exception {
        tool.clickUsingID(tool, "$as73pr_singleSelectImage_0");
        Thread.sleep(1000);
        Common.switchToThisWindow(tool, mainWindow);
    }

    public void saveNewTask() throws Exception {
        tool.clickUsingID(tool, "A4stqeq_label");
        Thread.sleep(3000);
    }

    public void clickNotesTab() throws Exception {
        tool.clickUsingXPath(tool, "//div[@id='subdividedTabs']/table/tbody/tr/td[3]/div");
        Thread.sleep(3000);
    }

    public void clickNewNote() throws Exception {
        tool.clickUsingID(tool, "Ad9csi6_label");
        Thread.sleep(3000);
    }

    public void selectNoteType(String noteType) throws Exception {
        tool.selectVisibleTextByID(tool, "Inl0w6r", noteType);
        Thread.sleep(1000);
    }

    public void setNoteDescription(String description) throws Exception {
        tool.enterStringUsingId(tool, "Irtjkff", description);
    }

    public void clickViewListNote() throws Exception {
        tool.clickUsingXPath(tool, "//div[@id='$gyuovx']/table/tbody/tr/td[2]/nobr");
        Thread.sleep(3000);
    }

    public void setTaskName(String name) throws Exception {
        tool.enterStringUsingId(tool, "Iyky4iy", name);
    }

    public void setTaskDescription(String description) throws Exception {
        tool.enterStringUsingId(tool, "Iigsi8h", description);
    }
}
