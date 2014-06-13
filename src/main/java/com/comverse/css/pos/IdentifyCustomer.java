package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.IdentifyCustomerCommon;

public class IdentifyCustomer extends IdentifyCustomerCommon {

    public IdentifyCustomer(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AccountDetails gotoAccountDashboardUsingAccountID(String accountID) throws Exception {
        super.gotoAccountDashboardUsingAccountID(accountID);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails gotoAccountDashboardUsingAccountLastName(String accountLastName) throws Exception {
        super.gotoAccountDashboardUsingAccountLastName(accountLastName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public CustomerSearchResult searchByAccountLastNameMultiplePersons(String lastName) throws Exception {

        super.searchByAccountLastNameMultiplePersons(lastName);
        return new CustomerSearchResult(tool, test, user);
    }

    @Override
    public AccountDetails searchByAccountLastNameSinglePerson(String lastName) throws Exception {

        super.searchByAccountLastNameSinglePerson(lastName);
        return new AccountDetails(tool, test, user);
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
    public AccountDetails searchByCaseID(String caseID) throws Exception {
        super.searchByCaseID(caseID);
        return new AccountDetails(tool, test, user);
    }

    public String getAccountId(String Fname) throws Exception {
        return tool.getTextUsingXPath(tool, "//td[contains(text(),'" + Fname + "')]/following-sibling::td");
    }

    @Override
    public SubscriberDetails searchBySubscriberMSISDN(String MSISDN) throws Exception {

        super.searchBySubscriberMSISDN(MSISDN);
        return new SubscriberDetails(tool, test, user);
    }
}
