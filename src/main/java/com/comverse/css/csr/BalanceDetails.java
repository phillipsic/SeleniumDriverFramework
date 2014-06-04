package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.BalanceDetailsCommon;

public class BalanceDetails extends BalanceDetailsCommon {

    public BalanceDetails(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    // From Account shared balance details page
    public BalanceDetails viewSubscriberBalanceDetails(String balanceName) throws Exception {

        super.viewSubscriberBalanceDetails(balanceName);
        return new BalanceDetails(driver);
    }

    @Override
    // From Subscriber balance details page
    public ViewBalance viewAccountBalances() throws Exception {

        super.viewAccountBalances();
        return new ViewBalance(driver);
    }

    @Override
    public ViewBalance clickGoToListOfBalances() throws Exception {

        super.clickGoToListOfBalances();
        return new ViewBalance(driver);
    }

}
