package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.csr.ViewCase;

public class EditCaseCommon extends CommonMenu {

    public EditCaseCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);

        // Check that we're on the right page.
        if (!"Edit Case".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Edit Case, but got: " + currentScreen);
        }
    }

    public void clickSave() throws Exception {
        tool.clickUsingName(tool, "closeonly");
    }

    public void clickCancelCase() throws Exception {
        tool.clickUsingName(tool, "cancelcase");
    }

    public void clickSaveAndCloseCase() throws Exception {
        tool.clickUsingID(tool, "cclose");
    }

    public void clickOKToCancelOrClose() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
    }

    public void enterReason(String Reason) throws Exception {
        
        tool.enterStringUsingId(tool, "reason", Reason);
    }

    public void selectJustificationStatus(String status) throws Exception {
        tool.selectVisibleTextByID(tool, "case_justification_status", status);
    }

    public void updateDescription(String updatedDescription) throws Exception {
        
        tool.enterStringUsingId(tool, "appendToDescription", updatedDescription);
    }

    public ViewCase clickOK() throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.assertTextOnPage(tool, "Case has been successfully updated.");
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCase(tool, test, user);
    }

    public void changePriorityToLow() throws Exception {
        tool.selectVisibleTextByID(tool, "case_priority", "Low");
    }

}
