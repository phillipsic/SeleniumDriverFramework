package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class ManageAccountCommon extends CommonMenu {

    public ManageAccountCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "Identify Customer";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon searchByAccountID(String accountID) throws Exception {

        driver.findElement(By.id("p-L2:40-L3:2150")).clear();
        driver.findElement(By.id("p-L2:40-L3:2150")).sendKeys(accountID);
        driver.findElement(By.cssSelector("input.submit")).click();

        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon searchByAccountLastName(String lastName) throws Exception {

        driver.findElement(By.id("accountLastName")).clear();
        driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        driver.findElement(By.name("accountExtendedButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new AccountDetailsCommon(driver);
    }

    public SearchResultsCommon searchAccountWildCard() throws Exception {

        driver.findElement(By.id("p-L2:40-L3:2150")).clear();
        driver.findElement(By.id("p-L2:40-L3:2150")).sendKeys("*");
        driver.findElement(By.cssSelector("input.submit")).click();

        return new SearchResultsCommon(driver);

    }

    public CustomerSearchResultCommon searchByAccountLastNameMultiplePersons(String lastName) throws Exception {

        driver.findElement(By.id("accountLastName")).clear();
        driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new CustomerSearchResultCommon(driver);
    }

    public AccountDetailsCommon searcByAccountLastNameSinglePerson(String lastName) throws Exception {

        driver.findElement(By.id("accountLastName")).clear();
        driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon gotoAccountDashboardUsingAccountID(String accountID) throws Exception {

        driver.findElement(By.id("accountId")).clear();
        driver.findElement(By.id("accountId")).sendKeys(accountID);
        driver.findElement(By.name("accountButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();

        if (currentScreen.equals("Customer search result")) {

            CustomerSearchResultCommon customerSearchResult = new CustomerSearchResultCommon(driver);
            customerSearchResult.clickAccountLink(accountID);
        }

        return new AccountDetailsCommon(driver);
    }
}
