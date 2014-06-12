/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewBalanceCommon;

public class ViewBalance extends ViewBalanceCommon {

    public ViewBalance(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public NonVoucherRecharge clickNonVoucherRechargeFreeAmount() throws Exception {

        super.clickNonVoucherRechargeFreeAmount();
        return new NonVoucherRecharge(tool, test, user);
    }

    @Override
    public AdjustBalanceDetails clickAdjustBalance(String balancename) throws Exception {

        super.clickAdjustBalance(balancename);
        return new AdjustBalanceDetails(tool, test, user);

    }

    public SubscriberDetails clickBackToSubscriberDashboard() throws Exception {

        super.clickBack();
        return new SubscriberDetails(tool, test, user);
    }

    public AccountDetails clickBackToAccountDashboard() throws Exception {

        super.clickBack();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public RechargeWithVoucher clickRechargeByVoucher() throws Exception {
        super.clickRechargeByVoucher();
        return new RechargeWithVoucher(tool, test, user);
    }

    @Override
    public BalanceDetails viewBalanceDetails(String balanceName) throws Exception {
        super.viewBalanceDetails(balanceName);
        return new BalanceDetails(tool, test, user);
    }

    @Override
    public ReconfigureBalance clickConfigureSharedBalance(String balanceName) throws Exception {

        super.clickConfigureSharedBalance(balanceName);
        return new ReconfigureBalance(tool, test, user);
    }

    @Override
    public ReconfigureBalance clickConfigureLimit(String balanceName) throws Exception {

        super.clickConfigureLimit(balanceName);
        return new ReconfigureBalance(tool, test, user);
    }

}
