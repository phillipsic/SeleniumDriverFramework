/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddNewCaseCommon extends CommonMenu {

    public AddNewCaseCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Add case";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }  // Check that we're on the right page.

    }

    public void selectCaseType(String caseType) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("categoryId", caseType);
    }

    public void selectCaseProblemArea(String problemArea) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("subCategoryId", problemArea);
    }

    public void enterCaseDescription(String caseDescription) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("description", caseDescription);
    }

    public void selectNoteType(String noteType) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("noteType", noteType);
    }

    public void enterNoteDescription(String noteDescription) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("note", noteDescription);
    }

    public AddCaseReviewCommon clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingName("ok");
        return new AddCaseReviewCommon(tool, test, user);
    }
}
