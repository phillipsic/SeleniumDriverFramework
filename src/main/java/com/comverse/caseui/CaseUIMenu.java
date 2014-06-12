package com.comverse.caseui;

import org.openqa.selenium.By;

import com.comverse.caseui.common.CaseUITest;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.PropertyHelper;

public class CaseUIMenu extends CaseUITest {

    public CaseUIMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickCaseManagement() {
        tool.driver.findElement(By.xpath("//div[contains(text(), 'Case Management')]")).click();
    }

    public CaseUICases clickCases() {
        tool.driver.findElement(By.xpath("//div[contains(text(), 'Cases')]")).click();
        return new CaseUICases(tool, test, user);
    }

    public void clickAccounts() {
        tool.driver.findElement(By.xpath("//div[contains(text(), 'Accounts')]")).click();
    }

    public CaseUIAccounts clickAccountsSub() {
        tool.driver.findElement(By.xpath("//div[8]/div[2]/div/table/tbody/tr/td[2]/div")).click();

        return new CaseUIAccounts(tool, test, user);
    }

    public long getWaitTime() {
        PropertyHelper propsHelper = new PropertyHelper();
        long waitSec = Long.valueOf(propsHelper.getInitProperties("sfa_wait"));
        return waitSec;
    }

    public void clickActivities() {
        tool.driver.findElement(By.xpath("//div[contains(text(), 'Activities')]")).click();
    }

    public void clickTasks() {
        tool.driver.findElement(By.xpath("//div[contains(text(), 'Tasks')]")).click();
    }

    public void clickSignOut() {
        tool.driver.findElement(By.id("$azn666_label")).click();

    }
}
