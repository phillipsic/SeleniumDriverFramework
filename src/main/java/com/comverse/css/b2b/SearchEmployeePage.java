package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SearchEmployeeCommon;

public class SearchEmployeePage extends SearchEmployeeCommon {

    public SearchEmployeePage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Search Employee";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public SearchEmployeePage searchEmployeeByLastName(String ln) throws Exception {

        super.searchEmployeeByLastName(ln);
        return new SearchEmployeePage(tool, test, user);
        // sends keys to the last name field in the searchpage and clicks Search
        // button of the same section. Expects the same page when completed.
    }

    @Override
    public SearchEmployeePage searchEmployeeByLogin(String lg) throws Exception {

        super.searchEmployeeByLogin(lg);
        return new SearchEmployeePage(tool, test, user);
        // sends keys to the login field in the searchpage and clicks Search
        // button of the same section. Expects the same page when completed.
    }

    @Override
    public ContactInformation clickEmployeeNameLink(String FirstOrLastName) throws Exception {

        super.clickEmployeeNameLink(FirstOrLastName);

        return new ContactInformation(tool, test, user);

    }

}
