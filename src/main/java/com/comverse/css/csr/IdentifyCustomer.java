package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.IdentifyCustomerCommon;

public class IdentifyCustomer extends IdentifyCustomerCommon {

    public IdentifyCustomer(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AccountDetails clickPersonSearchExpectingOneResult() throws Exception {

        super.clickPersonSearchExpectingOneResult();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails searchByAccountID(String accountID) throws Exception {

        super.searchByAccountID(accountID);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails searchByAccountLastNameSinglePerson(String lastName) throws Exception {

        super.searchByAccountLastNameSinglePerson(lastName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public void clickMoreLink() throws Exception {
        super.clickMoreLink();
    }

    @Override
    public void clickMoreLinkPerson() throws Exception {
        super.clickMoreLinkPerson();
    }

    @Override
    public AccountDetails searchByAccountFirstNameSinglePerson(String firstName) throws Exception {

        super.searchByAccountFirstNameSinglePerson(firstName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails searchByCompanyNameSinglePerson(String companyName) throws Exception {

        super.searchByCompanyNameSinglePerson(companyName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails gotoAccountDashboardUsingAccountID(String accountID) throws Exception {

        super.gotoAccountDashboardUsingAccountID(accountID);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails gotoAccountDashboardUsingAccountLastName(String lastName) throws Exception {

        super.gotoAccountDashboardUsingAccountLastName(lastName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public CustomerSearchResult searchByAccountLastNameMultiplePersons(String lastName) throws Exception {

        super.searchByAccountLastNameMultiplePersons(lastName);
        return new CustomerSearchResult(tool, test, user);
    }

    @Override
    public CustomerSearchResult searchByAccountFirstNameMultiplePersons(String firstName) throws Exception {

        super.searchByAccountFirstNameMultiplePersons(firstName);
        return new CustomerSearchResult(tool, test, user);
    }

    @Override
    public PersonIdentificationSearchResult clickPersonSearchExpectingManyResults() throws Exception {

        super.clickPersonSearchExpectingManyResults();
        return new PersonIdentificationSearchResult(tool, test, user);
    }

    @Override
    public AccountDetails searchByPersonLastNameSinglePerson(String lastName) throws Exception {

        super.searchByPersonLastNameSinglePerson(lastName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails searchByPersonFirstNameSinglePerson(String firstName) throws Exception {

        super.searchByPersonFirstNameSinglePerson(firstName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public void searchByPersonNatioanlIdMultiplePersons(String id) throws Exception {

        super.searchByPersonNatioanlIdMultiplePersons(id);
    }

    @Override
    public void searchByPersonDOBMultiplePersons(String DOB) throws Exception {

        super.searchByPersonDOBMultiplePersons(DOB);
    }

    @Override
    public CustomerSearchResult searchBySubscriberMSISDNMultiplePersons(String MSISDN) throws Exception {

        super.searchBySubscriberMSISDNMultiplePersons(MSISDN);
        return new CustomerSearchResult(tool, test, user);
    }

    @Override
    public SubscriberDetails searchBySubscriberMSISDN(String MSISDN) throws Exception {

        super.searchBySubscriberMSISDN(MSISDN);
        return new SubscriberDetails(tool, test, user);
    }
}
