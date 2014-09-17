package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.BalanceDetailsCommon;

public class BalanceDetails extends BalanceDetailsCommon {

    public BalanceDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    // From Account shared balance details page
    public BalanceDetails viewSubscriberBalanceDetails(String balanceName) throws Exception {
        super.viewSubscriberBalanceDetails(balanceName);
        return new BalanceDetails(tool, test, user);
    }

    @Override
    // From Subscriber balance details page
    public ViewBalance viewAccountBalances() throws Exception {
        super.viewAccountBalances();
        return new ViewBalance(tool, test, user);
    }

    @Override
    public ViewBalance clickGoToListOfBalances() throws Exception {
        super.clickGoToListOfBalances();
        return new ViewBalance(tool, test, user);
    }

}
