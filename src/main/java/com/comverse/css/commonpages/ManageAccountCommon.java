package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ManageAccountCommon extends CommonMenu {

    public ManageAccountCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Identify Customer";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AccountDetailsCommon searchByAccountID(String accountID) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-L2:40-L3:2150", accountID);
        tool.clickUsingCssSelector("input.submit");

        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountLastName(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("accountLastName", lastName);
        tool.clickUsingName("accountExtendedButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new AccountDetailsCommon(tool, test, user);
    }

    public SearchResultsCommon searchAccountWildCard() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-L2:40-L3:2150", "*");
        tool.clickUsingCssSelector("input.submit");

        return new SearchResultsCommon(tool, test, user);

    }

    public CustomerSearchResultCommon searchByAccountLastNameMultiplePersons(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("accountLastName", lastName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searcByAccountLastNameSinglePerson(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("accountLastName", lastName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon gotoAccountDashboardUsingAccountID(String accountID) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("accountId", accountID);
        tool.clickUsingName("accountButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();

        if (currentScreen.equals("Customer search result")) {

            CustomerSearchResultCommon customerSearchResult = new CustomerSearchResultCommon(tool, test, user);
            customerSearchResult.clickAccountLink(accountID);
        }

        return new AccountDetailsCommon(tool, test, user);
    }
}
