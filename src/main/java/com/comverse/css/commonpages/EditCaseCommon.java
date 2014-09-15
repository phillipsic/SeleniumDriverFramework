package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.csr.ViewCase;

public class EditCaseCommon extends CommonMenu {

    public EditCaseCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!"Edit Case".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Edit Case, but got: " + currentScreen);
        }
    }

    public void clickSave() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingName("closeonly");
    }

    public void clickCancelCase() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingName("cancelcase");
    }

    public void clickSaveAndCloseCase() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("cclose");
    }

    public void clickOKToCancelOrClose() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
    }

    public void enterReason(String Reason) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("reason", Reason);
    }

    public void selectJustificationStatus(String status) throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("case_justification_status", status);
    }

    public void updateDescription(String updatedDescription) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("appendToDescription", updatedDescription);
    }

    public ViewCase clickOK() throws Exception {
        test.writeInLog(Common.getMethodName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.assertTextOnPage(tool, "Case has been successfully updated.");
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCase(tool, test, user);
    }

    public void changePriorityToLow() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("case_priority", "Low");
    }

}
