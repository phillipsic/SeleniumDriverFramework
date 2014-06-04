/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBalanceCommon;

/**
 * 
 * @author gmaroth
 */
public class ViewBalance extends ViewBalanceCommon {

    public ViewBalance(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public NonVoucherRecharge clickNonVoucherRechargeFreeAmount() throws Exception {

        super.clickNonVoucherRechargeFreeAmount();
        return new NonVoucherRecharge(driver);
    }

    @Override
    public AdjustBalanceDetails clickAdjustBalance(String balancename) throws Exception {

        super.clickAdjustBalance(balancename);
        return new AdjustBalanceDetails(driver);

    }

    public SubscriberDetails clickBackToSubscriberDashboard() throws Exception {

        super.clickBack();
        return new SubscriberDetails(driver);
    }

    public AccountDetails clickBackToAccountDashboard() throws Exception {

        super.clickBack();
        return new AccountDetails(driver);
    }

    @Override
    public RechargeWithVoucher clickRechargeByVoucher() throws Exception {
        super.clickRechargeByVoucher();
        return new RechargeWithVoucher(driver);
    }

    @Override
    public BalanceDetails viewBalanceDetails(String balanceName) throws Exception {
        super.viewBalanceDetails(balanceName);
        return new BalanceDetails(driver);
    }

    @Override
    public ReconfigureBalance clickConfigureSharedBalance(String balanceName) throws Exception {

        super.clickConfigureSharedBalance(balanceName);
        return new ReconfigureBalance(driver);
    }

    @Override
    public ReconfigureBalance clickConfigureLimit(String balanceName) throws Exception {

        super.clickConfigureLimit(balanceName);
        return new ReconfigureBalance(driver);
    }

}
