/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewCaseCommon extends CommonMenu {
    static String expectedScreen = "Add Member - Confirmation";

    public AddNewCaseCommon(WebDriver driver) throws Exception {
        super(driver);

        // Check that we're on the right page.
        if (!"Add case".equals(driver.getTitle())) {

            throw new IllegalStateException("This is not the Add case page");
        }
    }

    public void selectCaseType(String caseType) throws Exception {

        //new Select(driver.findElement(By.id("categoryId"))).selectByVisibleText(caseType);

        Select select = new Select(driver.findElement(By.id("categoryId")));
        // select.deselectAll();
        select.selectByVisibleText(caseType);

    }

    public void selectCaseProblemArea(String problemArea) throws Exception {

        new Select(driver.findElement(By.id("subCategoryId"))).selectByVisibleText(problemArea);

    }

    public void enterCaseDescription(String caseDescription) throws Exception {

        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys(caseDescription);
    }

    public void selectNoteType(String noteType) throws Exception {

        new Select(driver.findElement(By.id("noteType"))).selectByVisibleText(noteType);

    }

    public void enterNoteDescription(String noteDescription) throws Exception {

        driver.findElement(By.id("note")).clear();
        driver.findElement(By.id("note")).sendKeys(noteDescription);
    }

    public AddCaseReviewCommon clickContinue() throws Exception {

        driver.findElement(By.name("ok")).click();
        return new AddCaseReviewCommon(driver);
    }
}
