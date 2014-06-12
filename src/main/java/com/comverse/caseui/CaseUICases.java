package com.comverse.caseui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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
        tool.driver.findElement(By.id("Arrza0b_label")).click();
        Thread.sleep(3000);
    }

    public void selectCaseType(String caseType) throws Exception {
        new Select(tool.driver.findElement(By.id("Ih4kclq"))).selectByVisibleText(caseType);
        Thread.sleep(1000);
    }

    public void selectProblemArea(String problemArea) throws Exception {
        new Select(tool.driver.findElement(By.id("Ii5gdu9"))).selectByVisibleText(problemArea);
        Thread.sleep(1000);
    }

    public void clickSearchAccount(String mainWindow) throws Exception {
        tool.driver.findElement(By.id("Ifhjkr4_img")).click();
        Thread.sleep(3000);
        Common.switchToNewWindow(tool, mainWindow);
    }

    public void clickSearch(String accountLastname) throws Exception {
        tool.driver.findElement(By.id("Ilgmxak")).sendKeys("%" + accountLastname + "%");
        tool.driver.findElement(By.id("$as73pr_filterbutton")).click();
        Thread.sleep(3000);
    }

    public void selectFirstAccount(String mainWindow) throws Exception {
        tool.driver.findElement(By.id("$as73pr_singleSelectImage_0")).click();
        Thread.sleep(1000);
        Common.switchToThisWindow(tool, mainWindow);
    }

    public void setCaseDescription(String description) {
        tool.driver.findElement(By.id("Iigsi8h")).sendKeys(description);
    }

    public void saveNewCase() throws Exception {
        tool.driver.findElement(By.id("A2my23m_label")).click();
        Thread.sleep(3000);
    }

    public String getCaseID() throws Exception {
        String caseID = tool.driver.findElement(By.xpath("//span[contains(text(), 'ID: ')]")).getText().substring(4);
        System.out.println("CaseId=" + caseID);
        return caseID;
    }

    public void changeCaseStatusToClose() throws Exception {
        new Select(tool.driver.findElement(By.id("Igdju7d"))).selectByVisibleText("Closed");
        Thread.sleep(1000);
    }

    public void changeJustificationStatusToProblemSolved() throws Exception {
        new Select(tool.driver.findElement(By.id("Iru5lh3"))).selectByVisibleText("Problem Solved");
        Thread.sleep(1000);
    }

    public void clickNotesTab() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='subdividedTabs']/table/tbody/tr/td[3]/div")).click();
        Thread.sleep(3000);
    }

    public void clickNewNote() throws Exception {
        tool.driver.findElement(By.id("Ad9csi6_label")).click();
        Thread.sleep(3000);
    }

    public void selectNoteType(String noteType) throws Exception {
        new Select(tool.driver.findElement(By.id("Inl0w6r"))).selectByVisibleText(noteType);
        Thread.sleep(1000);
    }

    public void setNoteDescription(String description) {
        tool.driver.findElement(By.id("Irtjkff")).sendKeys(description);
    }

    public void clickViewListNote() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='$gyuovx']/table/tbody/tr/td[2]/nobr")).click();
        Thread.sleep(3000);
    }
}
