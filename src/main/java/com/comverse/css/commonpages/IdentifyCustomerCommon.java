package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class IdentifyCustomerCommon extends CommonMenu {

    public IdentifyCustomerCommon(AutomationTool tool, Test test, User user) throws Exception {
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

    public AccountDetailsCommon searchByAccountID(String accountID) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("accountId", accountID);
        tool.clickUsingName("accountButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public void clickMoreLink() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.searchUsingID("More >>");

    }

    public void clickMoreLinkPerson() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@id='personLastName']/../../a");

    }

    public void searchByPersonNatioanlIdMultiplePersons(String id) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("nationalId", id);
        tool.clickUsingName("personButton");
    }

    public void searchByPersonDOBMultiplePersons(String DOB) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("dateOfBirth", DOB);
        tool.clickUsingName("personButton");
    }

    public AccountDetailsCommon searchByCaseID(String caseID) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("caseId", caseID);
        tool.clickUsingName("caseButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByCaseIDMultiplePersons(String caseID) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("caseId", caseID);
        tool.clickUsingName("caseButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon gotoAccountDashboardUsingAccountID(String accountID) throws Exception {  test.writeInLog(Common.getMethodName());

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

    public AccountDetailsCommon gotoAccountDashboardUsingAccountLastName(String lastName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("accountLastName", lastName);
        tool.clickUsingName("accountExtendedButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();

        if (currentScreen.equals("Customer search result")) {

            CustomerSearchResultCommon customerSearchResult = new CustomerSearchResultCommon(tool, test, user);
            customerSearchResult.clickFirstPersonLink();
        }

        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByAccountLastNameMultiplePersons(String lastName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("accountLastName", lastName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByAccountFirstNameMultiplePersons(String firstName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("accountFirstName", firstName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public SubscriberDetailsCommon searchBySubscriberMSISDN(String MSISDN) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("subscriberId", MSISDN);
        tool.clickUsingName("subscriberButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);

    }

    public CustomerSearchResultCommon searchBySubscriberMSISDNMultiplePersons(String MSISDN) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("subscriberId", MSISDN);
        tool.clickUsingName("subscriberButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountLastNameSinglePerson(String lastName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("accountLastName", lastName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByAccountFirstNameSinglePerson(String firstName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("accountFirstName", firstName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByCompanyNameSinglePerson(String companyName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("companyName", companyName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchByCompanyNameMultiplePersons(String companyName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("companyName", companyName);
        tool.clickUsingName("accountExtendedButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByPersonLastNameSinglePerson(String lastName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("personLastName", lastName);
        tool.clickUsingName("personButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon searchByPersonFirstNameSinglePerson(String firstName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("personFirstName", firstName);
        tool.clickUsingName("personButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public CustomerSearchResultCommon searchAccountWildCard() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("p-L2:40-L3:2150", "*");
        tool.clickUsingCssSelector("input.submit");

        return new CustomerSearchResultCommon(tool, test, user);
    }

    public void setPersonFirstName(String firstName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("personFirstName", firstName);
    }

    public void setPersonLastName(String lastName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("personLastName", lastName);
    }

    public void setNationalID(String nationID) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("nationalId", nationID);
    }

    public void setDateOfBirth(String dob) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("dateOfBirth", dob);
    }

    public PersonIdentificationSearchResultCommon clickPersonSearchExpectingManyResults() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingName("personButton");
        return new PersonIdentificationSearchResultCommon(tool, test, user);
    }

    public AccountDetailsCommon clickPersonSearchExpectingOneResult() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingName("personButton");
        return new AccountDetailsCommon(tool, test, user);
    }

    public void clickMorePersonSearchFields() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//a[contains(text(),'More >>')])[2]");
    }

    public void clickMoreSubscriberSearchFields() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingLinkText("More >>");
    }

    public void selectShadowOnly() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("subscriberType", "Shadow Only");
    }

    public void checkIncludeInactiveSubscriberID() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingID("includeInactiveSubscribers");
    }

    public SubscriberDetailsCommon clickSubscriberLink(String MSISDN) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingPartialLinkText(MSISDN);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }
}
