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
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("Arrza0b_label");
        Thread.sleep(3000);
    }

    public void selectCaseType(String caseType) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("Ih4kclq", caseType);
        Thread.sleep(1000);
    }

    public void selectProblemArea(String problemArea) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("Ii5gdu9", problemArea);
        Thread.sleep(1000);
    }

    public void clickSearchAccount(String mainWindow) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("Ifhjkr4_img");
        Thread.sleep(3000);
        Common.switchToNewWindow(tool, mainWindow);
    }

    public void clickSearch(String accountLastname) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.enterStringUsingId("Ilgmxak", "%" + accountLastname + "%");
        tool.clickUsingID("$as73pr_filterbutton");
        Thread.sleep(3000);
    }

    public void selectFirstAccount(String mainWindow) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("$as73pr_singleSelectImage_0");
        Thread.sleep(1000);
        Common.switchToThisWindow(tool, mainWindow);
    }

    public void setCaseDescription(String description) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.enterStringUsingId("Iigsi8h", description);
    }

    public void saveNewCase() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("A2my23m_label");
        Thread.sleep(3000);
    }

    public String getCaseID() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String caseID = tool.getTextUsingXPath("//span[contains(text(), 'ID: ')]").substring(4);
        System.out.println("CaseId=" + caseID);
        return caseID;
    }

    public void changeCaseStatusToClose() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("Igdju7d", "Closed");
        Thread.sleep(1000);
    }

    public void changeJustificationStatusToProblemSolved() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("Iru5lh3", "Problem Solved");
        Thread.sleep(1000);
    }

    public void clickNotesTab() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//div[@id='subdividedTabs']/table/tbody/tr/td[3]/div");
        Thread.sleep(3000);
    }

    public void clickNewNote() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("Ad9csi6_label");
        Thread.sleep(3000);
    }

    public void selectNoteType(String noteType) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("Inl0w6r", noteType);
        Thread.sleep(1000);
    }

    public void setNoteDescription(String description) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.enterStringUsingId("Irtjkff", description);
    }

    public void clickViewListNote() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//div[@id='$gyuovx']/table/tbody/tr/td[2]/nobr");
        Thread.sleep(3000);
    }
}
