package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;

public class IdentifyCustomerCommon extends CommonMenu {

    public IdentifyCustomerCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Identify Customer";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon searchByAccountID(String accountID) throws Exception {
        driver.findElement(By.id("accountId")).clear();
        driver.findElement(By.id("accountId")).sendKeys(accountID);
        driver.findElement(By.name("accountButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public void clickMoreLink() throws Exception {
        driver.findElement(By.id("More >>"));

    }

    public void clickMoreLinkPerson() throws Exception {
        driver.findElement(By.xpath("//input[@id='personLastName']/../../a")).click();

    }

    public void searchByPersonNatioanlIdMultiplePersons(String id) throws Exception {
        driver.findElement(By.id("nationalId")).clear();
        driver.findElement(By.id("nationalId")).sendKeys(id);
        driver.findElement(By.name("personButton")).click();
    }

    public void searchByPersonDOBMultiplePersons(String DOB) throws Exception {
        driver.findElement(By.id("dateOfBirth")).clear();
        driver.findElement(By.id("dateOfBirth")).sendKeys(DOB);
        driver.findElement(By.name("personButton")).click();
    }

    public AccountDetailsCommon searchByCaseID(String caseID) throws Exception {
        driver.findElement(By.id("caseId")).clear();
        driver.findElement(By.id("caseId")).sendKeys(caseID);
        driver.findElement(By.name("caseButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public CustomerSearchResultCommon searchByCaseIDMultiplePersons(String caseID) throws Exception {
        driver.findElement(By.id("caseId")).clear();
        driver.findElement(By.id("caseId")).sendKeys(caseID);
        driver.findElement(By.name("caseButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(driver);
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

    public AccountDetailsCommon gotoAccountDashboardUsingAccountLastName(String lastName) throws Exception {

        driver.findElement(By.id("accountLastName")).clear();
        driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        driver.findElement(By.name("accountExtendedButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();

        if (currentScreen.equals("Customer search result")) {

            CustomerSearchResultCommon customerSearchResult = new CustomerSearchResultCommon(driver);
            customerSearchResult.clickFirstPersonLink();
        }

        return new AccountDetailsCommon(driver);
    }

    public CustomerSearchResultCommon searchByAccountLastNameMultiplePersons(String lastName) throws Exception {

        driver.findElement(By.id("accountLastName")).clear();
        driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(driver);
    }

    public CustomerSearchResultCommon searchByAccountFirstNameMultiplePersons(String firstName) throws Exception {

        driver.findElement(By.id("accountFirstName")).clear();
        driver.findElement(By.id("accountFirstName")).sendKeys(firstName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(driver);
    }

    public SubscriberDetailsCommon searchBySubscriberMSISDN(String MSISDN) throws Exception {

        driver.findElement(By.id("subscriberId")).clear();
        driver.findElement(By.id("subscriberId")).sendKeys(MSISDN);
        driver.findElement(By.name("subscriberButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(driver);

    }

    public CustomerSearchResultCommon searchBySubscriberMSISDNMultiplePersons(String MSISDN) throws Exception {

        driver.findElement(By.id("subscriberId")).clear();
        driver.findElement(By.id("subscriberId")).sendKeys(MSISDN);
        driver.findElement(By.name("subscriberButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(driver);
    }

    public AccountDetailsCommon searchByAccountLastNameSinglePerson(String lastName) throws Exception {

        driver.findElement(By.id("accountLastName")).clear();
        driver.findElement(By.id("accountLastName")).sendKeys(lastName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon searchByAccountFirstNameSinglePerson(String firstName) throws Exception {

        driver.findElement(By.id("accountFirstName")).clear();
        driver.findElement(By.id("accountFirstName")).sendKeys(firstName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon searchByCompanyNameSinglePerson(String companyName) throws Exception {

        driver.findElement(By.id("companyName")).clear();
        driver.findElement(By.id("companyName")).sendKeys(companyName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public CustomerSearchResultCommon searchByCompanyNameMultiplePersons(String companyName) throws Exception {

        driver.findElement(By.id("companyName")).clear();
        driver.findElement(By.id("companyName")).sendKeys(companyName);
        driver.findElement(By.name("accountExtendedButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(driver);
    }

    public AccountDetailsCommon searchByPersonLastNameSinglePerson(String lastName) throws Exception {

        driver.findElement(By.id("personLastName")).clear();
        driver.findElement(By.id("personLastName")).sendKeys(lastName);
        driver.findElement(By.name("personButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon searchByPersonFirstNameSinglePerson(String firstName) throws Exception {

        driver.findElement(By.id("personFirstName")).clear();
        driver.findElement(By.id("personFirstName")).sendKeys(firstName);
        driver.findElement(By.name("personButton")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public CustomerSearchResultCommon searchAccountWildCard() throws Exception {

        driver.findElement(By.id("p-L2:40-L3:2150")).clear();
        driver.findElement(By.id("p-L2:40-L3:2150")).sendKeys("*");
        driver.findElement(By.cssSelector("input.submit")).click();

        return new CustomerSearchResultCommon(driver);
    }

    public void setPersonFirstName(String firstName) throws Exception {

        driver.findElement(By.id("personFirstName")).clear();
        driver.findElement(By.id("personFirstName")).sendKeys(firstName);
    }

    public void setPersonLastName(String lastName) throws Exception {

        driver.findElement(By.id("personLastName")).clear();
        driver.findElement(By.id("personLastName")).sendKeys(lastName);
    }

    public void setNationalID(String nationID) throws Exception {

        driver.findElement(By.id("nationalId")).clear();
        driver.findElement(By.id("nationalId")).sendKeys(nationID);
    }

    public void setDateOfBirth(String dob) throws Exception {

        driver.findElement(By.id("dateOfBirth")).clear();
        driver.findElement(By.id("dateOfBirth")).sendKeys(dob);
    }

    public PersonIdentificationSearchResultCommon clickPersonSearchExpectingManyResults() throws Exception {

        driver.findElement(By.name("personButton")).click();
        return new PersonIdentificationSearchResultCommon(driver);
    }

    public AccountDetailsCommon clickPersonSearchExpectingOneResult() throws Exception {

        driver.findElement(By.name("personButton")).click();
        return new AccountDetailsCommon(driver);
    }

    public void clickMorePersonSearchFields() throws Exception {

        driver.findElement(By.xpath("(//a[contains(text(),'More >>')])[2]")).click();
    }

    public void clickMoreSubscriberSearchFields() throws Exception {
        driver.findElement(By.linkText("More >>")).click();
    }

    public void selectShadowOnly() throws Exception {
        new Select(driver.findElement(By.id("subscriberType"))).selectByVisibleText("Shadow Only");
    }

    public void checkIncludeInactiveSubscriberID() throws Exception {
        driver.findElement(By.id("includeInactiveSubscribers")).click();
    }

    public SubscriberDetailsCommon clickSubscriberLink(String MSISDN) throws Exception {

        driver.findElement(By.partialLinkText(MSISDN)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(driver);
    }
}
