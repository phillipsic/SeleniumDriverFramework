package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;
import com.comverse.css.csr.ViewCase;

public class EditCaseCommon extends CommonMenu {

    public EditCaseCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!"Edit Case".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Edit Case, but got: " + currentScreen);
        }
    }

    public void clickSave() throws Exception {
        driver.findElement(By.name("closeonly")).click();
    }

    public void clickCancelCase() throws Exception {
        driver.findElement(By.name("cancelcase")).click();
    }

    public void clickSaveAndCloseCase() throws Exception {
        driver.findElement(By.id("cclose")).click();
    }

    public void clickOKToCancelOrClose() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void enterReason(String Reason) throws Exception {
        driver.findElement(By.id("reason")).clear();
        driver.findElement(By.id("reason")).sendKeys(Reason);
    }

    public void selectJustificationStatus(String status) throws Exception {
        new Select(driver.findElement(By.id("case_justification_status"))).selectByVisibleText(status);
    }

    public void updateDescription(String updatedDescription) throws Exception {
        driver.findElement(By.id("appendToDescription")).clear();
        driver.findElement(By.id("appendToDescription")).sendKeys(updatedDescription);
    }

    public ViewCase clickOK() throws Exception {
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.assertTextOnPage(driver, "Case has been successfully updated.");
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewCase(driver);
    }

    public void changePriorityToLow() throws Exception {
        new Select(driver.findElement(By.id("case_priority"))).selectByVisibleText("Low");
    }

}
