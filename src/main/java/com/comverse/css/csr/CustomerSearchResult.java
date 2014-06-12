package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CustomerSearchResultCommon;

public class CustomerSearchResult extends CustomerSearchResultCommon {

    public CustomerSearchResult(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AccountDetails clickPersonNameLink(String lastName) throws Exception {

        super.clickPersonNameLink(lastName);
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails clickFirstAccountLink() throws Exception {

        super.clickFirstAccountLink();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public SubscriberDetails clickSubscriberLink(String MSISDN) throws Exception {

        super.clickSubscriberLink(MSISDN);
        return new SubscriberDetails(tool, test, user);
    }
}
