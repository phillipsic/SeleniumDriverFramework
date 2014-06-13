package com.comverse.caseui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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
        tool.driver.findElement(By.id("Alhzdry_label")).click();
        Thread.sleep(3000);
    }

    public void clickSearchAccount(String mainWindow) throws Exception {
        tool.driver.findElement(By.id("Ifhjkr4_img")).click();
        Thread.sleep(3000);
        Common.switchToNewWindow(tool, mainWindow);
    }

    public void clickSearch(String accountLastname) throws Exception {
        tool.enterStringUsingId(tool, "Ilgmxak", "%" + accountLastname);
        tool.driver.findElement(By.id("$as73pr_filterbutton")).click();
        Thread.sleep(3000);
    }

    public void selectFirstAccount(String mainWindow) throws Exception {
        tool.driver.findElement(By.id("$as73pr_singleSelectImage_0")).click();
        Thread.sleep(1000);
        Common.switchToThisWindow(tool, mainWindow);
    }

    public void saveNewTask() throws Exception {
        tool.driver.findElement(By.id("A4stqeq_label")).click();
        Thread.sleep(3000);
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
        new Select(tool.searchUsingID(tool, "Inl0w6r")).selectByVisibleText(noteType);
        Thread.sleep(1000);
    }

    public void setNoteDescription(String description) throws Exception {
        tool.enterStringUsingId(tool, "Irtjkff", description);
    }

    public void clickViewListNote() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='$gyuovx']/table/tbody/tr/td[2]/nobr")).click();
        Thread.sleep(3000);
    }

    public void setTaskName(String name) throws Exception {
        tool.enterStringUsingId(tool, "Iyky4iy", name);
    }

    public void setTaskDescription(String description) throws Exception {
        tool.enterStringUsingId(tool, "Iigsi8h", description);
    }
}
