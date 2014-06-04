package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ReconfigureBalanceCommon;

public class ReconfigureBalance extends ReconfigureBalanceCommon {

    public ReconfigureBalance(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    public ReconfigureBalance setMoreUnitsForThisPeriod(String unitsToAdd) throws Exception {

        super.setMoreUnitsForThisPeriod(unitsToAdd);
        return new ReconfigureBalance(driver);
    }

    @Override
    public ReconfigureBalanceReview clickAddUnits() throws Exception {

        super.clickAddUnits();
        return new ReconfigureBalanceReview(driver);
    }

    @Override
    public ReconfigureBalance setCreditSpendingLimit(String limitValue) throws Exception {

        super.setCreditSpendingLimit(limitValue);
        return new ReconfigureBalance(driver);
    }

    @Override
    public ReconfigureBalance setCreditSpendingLimitUnlimited() throws Exception {

        super.setCreditSpendingLimitUnlimited();
        return new ReconfigureBalance(driver);
    }

    @Override
    public ReconfigureBalanceReview clickReconfigureBalance() throws Exception {

        super.clickReconfigureBalance();
        return new ReconfigureBalanceReview(driver);
    }

}
