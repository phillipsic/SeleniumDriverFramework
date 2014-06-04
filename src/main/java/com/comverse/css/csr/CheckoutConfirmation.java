package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.CheckoutConfirmationCommon;

public class CheckoutConfirmation extends CheckoutConfirmationCommon {

    public CheckoutConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public WorkSpace clickOk() throws Exception {

        super.clickOk();
        return new WorkSpace(driver);
    }

    @Override
    public AccountDetails clickAccounts() throws Exception {
        super.clickAccounts();
        return new AccountDetails(driver);
    }

    @Override
    public AccountDetails clickOkExpectingAccountDashboard() throws Exception {

        super.clickOkExpectingAccountDashboard();
        return new AccountDetails(driver);
    }

    @Override
    public SubscriberDetails clickOkExpectingSubscriberDashboard() throws Exception {

        super.clickOkExpectingSubscriberDashboard();
        return new SubscriberDetails(driver);
    }
}
