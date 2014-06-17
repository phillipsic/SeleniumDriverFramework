package com.comverse.css.b2c;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddCase extends B2CMenu {

    public AddCase(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Add Case";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectCategory(String value) throws Exception {

        tool.selectVisibleTextByID(tool, "categoryId", value);
    }

    public void selectSubCategory(String value) throws Exception {

        tool.selectVisibleTextByID(tool, "subCategoryId", value);
    }

    public void enterDescription(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "description", value);
    }

    public void selectSubjectRelativeToProblemSubscriber() throws Exception {
        tool.clickUsingID(tool, "isContract");
    }

    public void selectFirstSubscriber() throws Exception {

        new Select(tool.searchUsingID(tool, "contract")).selectByIndex(1);
    }

    public AddCaseReview clickSubmit() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Submit']");
        return new AddCaseReview(tool, test, user);
    }

    public ListCases clickListCases() throws Exception {

        tool.clickUsingID(tool, "smnu_CASE_LIST");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ListCases(tool, test, user);
    }
}
