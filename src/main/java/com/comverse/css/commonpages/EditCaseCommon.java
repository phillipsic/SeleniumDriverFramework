package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.csr.ViewCase;

public class EditCaseCommon extends CommonMenu {

    public EditCaseCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!"Edit Case".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Edit Case, but got: " + currentScreen);
        }
    }

    public void clickSave() throws Exception {
        tool.driver.findElement(By.name("closeonly")).click();
    }

    public void clickCancelCase() throws Exception {
        tool.driver.findElement(By.name("cancelcase")).click();
    }

    public void clickSaveAndCloseCase() throws Exception {
        tool.driver.findElement(By.id("cclose")).click();
    }

    public void clickOKToCancelOrClose() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void enterReason(String Reason) throws Exception {
        tool.driver.findElement(By.id("reason")).clear();
        tool.driver.findElement(By.id("reason")).sendKeys(Reason);
    }

    public void selectJustificationStatus(String status) throws Exception {
        new Select(tool.searchUsingID(tool, "case_justification_status")).selectByVisibleText(status);
    }

    public void updateDescription(String updatedDescription) throws Exception {
        tool.driver.findElement(By.id("appendToDescription")).clear();
        tool.driver.findElement(By.id("appendToDescription")).sendKeys(updatedDescription);
    }

    public ViewCase clickOK() throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.assertTextOnPage(tool, "Case has been successfully updated.");
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCase(tool, test, user);
    }

    public void changePriorityToLow() throws Exception {
        new Select(tool.searchUsingID(tool, "case_priority")).selectByVisibleText("Low");
    }

}
