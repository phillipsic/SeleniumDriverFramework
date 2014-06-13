package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class IdentifyCustomerCommon extends CommonMenu {

    public IdentifyCustomerCommon(AutomationTool tool, Test test, User user) throws Exception {
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
        tool.driver.findElement(By.id("accountId")).clear();
        tool.driver.findElement(By.id("accountId")).sendKeys(accountID);
        tool.driver.findElement(By.name("accountButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public void clickMoreLink() throws Exception {
        tool.driver.findElement(By.id("More >>"));

    }

    public void clickMoreLinkPerson() throws Exception {
        tool.driver.findElement(By.xpath("//input[@id='personLastName']/../../a")).click();

    }

    public void searchByPersonNatioanlIdMultiplePersons(String id) throws Exception {
        tool.driver.findElement(By.id("nationalId")).clear();
        tool.driver.findElement(By.id("nationalId")).sendKeys(id);
        tool.driver.findElement(By.name("personButton")).click();
    }

    public void searchByPersonDOBMultiplePersons(String DOB) throws Exception {
        tool.driver.findElement(By.id("dateOfBirth")).clear();
        tool.driver.findElement(By.id("dateOfBirth")).sendKeys(DOB);
        tool.driver.findElement(By.name("personButton")).click();
    }

    public AccountDetailsCommon searchByCaseID(String caseID) throws Exception {
        tool.driver.findElement(By.id("caseId")).clear();
        tool.driver.findElement(By.id("caseId")).sendKeys(caseID);
        tool.driver.findElement(By.name("caseButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByCaseIDMultiplePersons(String caseID) throws Exception {
        tool.driver.findElement(By.id("caseId")).clear();
        tool.driver.findElement(By.id("caseId")).sendKeys(caseID);
        tool.driver.findElement(By.name("caseButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
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

    public AccountDetailsCommon gotoAccountDashboardUsingAccountLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("accountLastName")).clear();
        tool.driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();

        if (currentScreen.equals("Customer search result")) {

            CustomerSearchResultCommon customerSearchResult = new CustomerSearchResultCommon(tool, test, user);
            customerSearchResult.clickFirstPersonLink();
        }

        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByAccountLastNameMultiplePersons(String lastName) throws Exception {

        tool.driver.findElement(By.id("accountLastName")).clear();
        tool.driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByAccountFirstNameMultiplePersons(String firstName) throws Exception {

        tool.driver.findElement(By.id("accountFirstName")).clear();
        tool.driver.findElement(By.id("accountFirstName")).sendKeys(firstName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public SubscriberDetailsCommon searchBySubscriberMSISDN(String MSISDN) throws Exception {

        tool.driver.findElement(By.id("subscriberId")).clear();
        tool.driver.findElement(By.id("subscriberId")).sendKeys(MSISDN);
        tool.driver.findElement(By.name("subscriberButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);

    }

    public CustomerSearchResultCommon searchBySubscriberMSISDNMultiplePersons(String MSISDN) throws Exception {

        tool.driver.findElement(By.id("subscriberId")).clear();
        tool.driver.findElement(By.id("subscriberId")).sendKeys(MSISDN);
        tool.driver.findElement(By.name("subscriberButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountLastNameSinglePerson(String lastName) throws Exception {

        tool.driver.findElement(By.id("accountLastName")).clear();
        tool.driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountFirstNameSinglePerson(String firstName) throws Exception {

        tool.driver.findElement(By.id("accountFirstName")).clear();
        tool.driver.findElement(By.id("accountFirstName")).sendKeys(firstName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByCompanyNameSinglePerson(String companyName) throws Exception {

        tool.driver.findElement(By.id("companyName")).clear();
        tool.driver.findElement(By.id("companyName")).sendKeys(companyName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByCompanyNameMultiplePersons(String companyName) throws Exception {

        tool.driver.findElement(By.id("companyName")).clear();
        tool.driver.findElement(By.id("companyName")).sendKeys(companyName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByPersonLastNameSinglePerson(String lastName) throws Exception {

        tool.driver.findElement(By.id("personLastName")).clear();
        tool.driver.findElement(By.id("personLastName")).sendKeys(lastName);
        tool.driver.findElement(By.name("personButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByPersonFirstNameSinglePerson(String firstName) throws Exception {

        tool.driver.findElement(By.id("personFirstName")).clear();
        tool.driver.findElement(By.id("personFirstName")).sendKeys(firstName);
        tool.driver.findElement(By.name("personButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchAccountWildCard() throws Exception {

        tool.driver.findElement(By.id("p-L2:40-L3:2150")).clear();
        tool.driver.findElement(By.id("p-L2:40-L3:2150")).sendKeys("*");
        tool.driver.findElement(By.cssSelector("input.submit")).click();

        return new CustomerSearchResultCommon(tool, test, user);
    }

    public void setPersonFirstName(String firstName) throws Exception {

        tool.driver.findElement(By.id("personFirstName")).clear();
        tool.driver.findElement(By.id("personFirstName")).sendKeys(firstName);
    }

    public void setPersonLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("personLastName")).clear();
        tool.driver.findElement(By.id("personLastName")).sendKeys(lastName);
    }

    public void setNationalID(String nationID) throws Exception {

        tool.driver.findElement(By.id("nationalId")).clear();
        tool.driver.findElement(By.id("nationalId")).sendKeys(nationID);
    }

    public void setDateOfBirth(String dob) throws Exception {

        tool.driver.findElement(By.id("dateOfBirth")).clear();
        tool.driver.findElement(By.id("dateOfBirth")).sendKeys(dob);
    }

    public PersonIdentificationSearchResultCommon clickPersonSearchExpectingManyResults() throws Exception {

        tool.driver.findElement(By.name("personButton")).click();
        return new PersonIdentificationSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon clickPersonSearchExpectingOneResult() throws Exception {

        tool.driver.findElement(By.name("personButton")).click();
        return new AccountDetailsCommon(tool, test, user);
    }

    public void clickMorePersonSearchFields() throws Exception {

        tool.driver.findElement(By.xpath("(//a[contains(text(),'More >>')])[2]")).click();
    }

    public void clickMoreSubscriberSearchFields() throws Exception {
        tool.driver.findElement(By.linkText("More >>")).click();
    }

    public void selectShadowOnly() throws Exception {
        new Select(tool.searchUsingID(tool, "subscriberType")).selectByVisibleText("Shadow Only");
    }

    public void checkIncludeInactiveSubscriberID() throws Exception {
        tool.driver.findElement(By.id("includeInactiveSubscribers")).click();
    }

    public SubscriberDetailsCommon clickSubscriberLink(String MSISDN) throws Exception {

        tool.driver.findElement(By.partialLinkText(MSISDN)).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }
}
