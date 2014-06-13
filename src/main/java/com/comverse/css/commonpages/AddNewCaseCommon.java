/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddNewCaseCommon extends CommonMenu {
    static String expectedScreen = "Add Member - Confirmation";

    public AddNewCaseCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        // Check that we're on the right page.
        if (!"Add case".equals(tool.driver.getTitle())) {

            throw new IllegalStateException("This is not the Add case page");
        }
    }

    public void selectCaseType(String caseType) throws Exception {

        // new
        // Select(tool.searchUsingID(tool, "categoryId")).selectByVisibleText(caseType);

        Select select = new Select(tool.searchUsingID(tool, "categoryId"));
        // select.deselectAll();
        select.selectByVisibleText(caseType);

    }

    public void selectCaseProblemArea(String problemArea) throws Exception {

        new Select(tool.searchUsingID(tool, "subCategoryId")).selectByVisibleText(problemArea);

    }

    public void enterCaseDescription(String caseDescription) throws Exception {

        
        tool.enterStringUsingId(tool, "description", caseDescription);
    }

    public void selectNoteType(String noteType) throws Exception {

        new Select(tool.searchUsingID(tool, "noteType")).selectByVisibleText(noteType);

    }

    public void enterNoteDescription(String noteDescription) throws Exception {

        
        tool.enterStringUsingId(tool, "note", noteDescription);
    }

    public AddCaseReviewCommon clickContinue() throws Exception {

        tool.clickUsingName(tool, "ok");
        return new AddCaseReviewCommon(tool, test, user);
    }
}
