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

        tool.enterStringUsingId(tool, "accountId", accountID);
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

        tool.enterStringUsingId(tool, "nationalId", id);
        tool.driver.findElement(By.name("personButton")).click();
    }

    public void searchByPersonDOBMultiplePersons(String DOB) throws Exception {

        tool.enterStringUsingId(tool, "dateOfBirth", DOB);
        tool.driver.findElement(By.name("personButton")).click();
    }

    public AccountDetailsCommon searchByCaseID(String caseID) throws Exception {

        tool.enterStringUsingId(tool, "caseId", caseID);
        tool.driver.findElement(By.name("caseButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByCaseIDMultiplePersons(String caseID) throws Exception {

        tool.enterStringUsingId(tool, "caseId", caseID);
        tool.driver.findElement(By.name("caseButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon gotoAccountDashboardUsingAccountID(String accountID) throws Exception {

        tool.enterStringUsingId(tool, "accountId", accountID);
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

        tool.enterStringUsingId(tool, "accountLastName", lastName);
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

        tool.enterStringUsingId(tool, "accountLastName", lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByAccountFirstNameMultiplePersons(String firstName) throws Exception {

        tool.enterStringUsingId(tool, "accountFirstName", firstName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public SubscriberDetailsCommon searchBySubscriberMSISDN(String MSISDN) throws Exception {

        tool.enterStringUsingId(tool, "subscriberId", MSISDN);
        tool.driver.findElement(By.name("subscriberButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);

    }

    public CustomerSearchResultCommon searchBySubscriberMSISDNMultiplePersons(String MSISDN) throws Exception {

        tool.enterStringUsingId(tool, "subscriberId", MSISDN);
        tool.driver.findElement(By.name("subscriberButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountLastNameSinglePerson(String lastName) throws Exception {

        tool.enterStringUsingId(tool, "accountLastName", lastName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountFirstNameSinglePerson(String firstName) throws Exception {

        tool.enterStringUsingId(tool, "accountFirstName", firstName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByCompanyNameSinglePerson(String companyName) throws Exception {

        tool.enterStringUsingId(tool, "companyName", companyName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByCompanyNameMultiplePersons(String companyName) throws Exception {

        tool.enterStringUsingId(tool, "companyName", companyName);
        tool.driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByPersonLastNameSinglePerson(String lastName) throws Exception {

        tool.enterStringUsingId(tool, "personLastName", lastName);
        tool.driver.findElement(By.name("personButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByPersonFirstNameSinglePerson(String firstName) throws Exception {

        tool.enterStringUsingId(tool, "personFirstName", firstName);
        tool.driver.findElement(By.name("personButton")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchAccountWildCard() throws Exception {

        tool.enterStringUsingId(tool, "p-L2:40-L3:2150", "*");
        tool.clickUsingCssSelector(tool, "input.submit");

        return new CustomerSearchResultCommon(tool, test, user);
    }

    public void setPersonFirstName(String firstName) throws Exception {

        tool.enterStringUsingId(tool, "personFirstName", firstName);
    }

    public void setPersonLastName(String lastName) throws Exception {

        tool.enterStringUsingId(tool, "personLastName", lastName);
    }

    public void setNationalID(String nationID) throws Exception {

        tool.enterStringUsingId(tool, "nationalId", nationID);
    }

    public void setDateOfBirth(String dob) throws Exception {

        tool.enterStringUsingId(tool, "dateOfBirth", dob);
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
        tool.clickUsingLinkText(tool, "More >>");
    }

    public void selectShadowOnly() throws Exception {
        new Select(tool.searchUsingID(tool, "subscriberType")).selectByVisibleText("Shadow Only");
    }

    public void checkIncludeInactiveSubscriberID() throws Exception {
        tool.driver.findElement(By.id("includeInactiveSubscribers")).click();
    }

    public SubscriberDetailsCommon clickSubscriberLink(String MSISDN) throws Exception {

        tool.clickUsingPartialLinkText(tool, MSISDN);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }
}
