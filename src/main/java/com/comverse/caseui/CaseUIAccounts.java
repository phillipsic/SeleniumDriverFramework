package com.comverse.caseui;

import org.openqa.selenium.By;

import com.comverse.caseui.common.CaseUITest;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CaseUIAccounts extends CaseUITest {

    public CaseUIAccounts(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickSearch(String accountLastname) throws Exception {
        tool.enterStringUsingId(tool, "Ih246r", "%" + accountLastname);
        tool.driver.findElement(By.id("$79ot1w_filterbutton")).click();
        Thread.sleep(3000);
    }

    public void selectFirstAccount(String mainWindow) throws Exception {
        tool.driver.findElement(By.id("$79ot1w_cell_0_0_Img")).click();
        Thread.sleep(1000);
        Common.switchToThisWindow(tool, mainWindow);
    }

    public void clickCasesTab() throws Exception {
        tool.clickUsingXPath(tool, "//div[contains(text(),'Cases') and @class='tabsDarkTab']");

        Thread.sleep(3000);
    }
}
