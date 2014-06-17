package com.comverse.caseui;

import com.comverse.caseui.common.CaseUITest;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CaseUICases extends CaseUITest {

    public CaseUICases(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickNewCase() throws Exception {
        tool.clickUsingID(tool, "Arrza0b_label");
        Thread.sleep(3000);
    }

    public void selectCaseType(String caseType) throws Exception {
        tool.selectVisibleTextByID(tool, "Ih4kclq", caseType);
        Thread.sleep(1000);
    }

    public void selectProblemArea(String problemArea) throws Exception {
        tool.selectVisibleTextByID(tool, "Ii5gdu9", problemArea);
        Thread.sleep(1000);
    }

    public void clickSearchAccount(String mainWindow) throws Exception {
        tool.clickUsingID(tool, "Ifhjkr4_img");
        Thread.sleep(3000);
        Common.switchToNewWindow(tool, mainWindow);
    }

    public void clickSearch(String accountLastname) throws Exception {
        tool.enterStringUsingId(tool, "Ilgmxak", "%" + accountLastname + "%");
        tool.clickUsingID(tool, "$as73pr_filterbutton");
        Thread.sleep(3000);
    }

    public void selectFirstAccount(String mainWindow) throws Exception {
        tool.clickUsingID(tool, "$as73pr_singleSelectImage_0");
        Thread.sleep(1000);
        Common.switchToThisWindow(tool, mainWindow);
    }

    public void setCaseDescription(String description) throws Exception {
        tool.enterStringUsingId(tool, "Iigsi8h", description);
    }

    public void saveNewCase() throws Exception {
        tool.clickUsingID(tool, "A2my23m_label");
        Thread.sleep(3000);
    }

    public String getCaseID() throws Exception {
        String caseID = tool.getTextUsingXPath(tool, "//span[contains(text(), 'ID: ')]").substring(4);
        System.out.println("CaseId=" + caseID);
        return caseID;
    }

    public void changeCaseStatusToClose() throws Exception {
        tool.selectVisibleTextByID(tool, "Igdju7d", "Closed");
        Thread.sleep(1000);
    }

    public void changeJustificationStatusToProblemSolved() throws Exception {
        tool.selectVisibleTextByID(tool, "Iru5lh3", "Problem Solved");
        Thread.sleep(1000);
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
}
