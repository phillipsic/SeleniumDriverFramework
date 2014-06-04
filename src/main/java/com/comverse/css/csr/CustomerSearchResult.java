package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.CustomerSearchResultCommon;

public class CustomerSearchResult extends CustomerSearchResultCommon {

    public CustomerSearchResult(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public AccountDetails clickPersonNameLink(String lastName) throws Exception {

        super.clickPersonNameLink(lastName);
        return new AccountDetails(driver);
    }

    @Override
    public AccountDetails clickFirstAccountLink() throws Exception {

        super.clickFirstAccountLink();
        return new AccountDetails(driver);
    }

    @Override
    public SubscriberDetails clickSubscriberLink(String MSISDN) throws Exception {

        super.clickSubscriberLink(MSISDN);
        return new SubscriberDetails(driver);
    }
}
