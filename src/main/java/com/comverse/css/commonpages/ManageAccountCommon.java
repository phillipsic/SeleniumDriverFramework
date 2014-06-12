package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ManageAccountCommon extends CommonMenu {

    public ManageAccountCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Identify Customer";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon searchByAccountID(String accountID) throws Exception {

        tool.driver.findElement(By.id("p-L2:40-L3:2150")).clear();
        tool.driver.findElement(By.id("p-L2:40-L3:2150")).sendKeys(accountID);
        tool.driver.findElement(By.cssSelector("input.submit")).click();

        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("accountLastName")).clear();
        tool.driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new AccountDetailsCommon(tool, test, user);
    }

    public SearchResultsCommon searchAccountWildCard() throws Exception {

        tool.driver.findElement(By.id("p-L2:40-L3:2150")).clear();
        tool.driver.findElement(By.id("p-L2:40-L3:2150")).sendKeys("*");
        tool.driver.findElement(By.cssSelector("input.submit")).click();

        return new SearchResultsCommon(tool, test, user);

    }

    public CustomerSearchResultCommon searchByAccountLastNameMultiplePersons(String lastName) throws Exception {

        tool.driver.findElement(By.id("accountLastName")).clear();
        tool.driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searcByAccountLastNameSinglePerson(String lastName) throws Exception {

        tool.driver.findElement(By.id("accountLastName")).clear();
        tool.driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon gotoAccountDashboardUsingAccountID(String accountID) throws Exception {

        tool.driver.findElement(By.id("accountId")).clear();
        tool.driver.findElement(By.id("accountId")).sendKeys(accountID);
        tool.driver.findElement(By.name("accountButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();

        if (currentScreen.equals("Customer search result")) {

            CustomerSearchResultCommon customerSearchResult = new CustomerSearchResultCommon(tool, test, user);
            customerSearchResult.clickAccountLink(accountID);
        }

        return new AccountDetailsCommon(tool, test, user);
    }
}
