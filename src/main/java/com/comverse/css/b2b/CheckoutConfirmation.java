package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CheckoutConfirmationCommon;

public class CheckoutConfirmation extends CheckoutConfirmationCommon {

    public CheckoutConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AccountDetails clickAccounts() throws Exception {
        tool.clickUsingID("mnu_ACCOUNTS");
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails clickOkExpectingAccountDashboard() throws Exception {

        super.clickOkExpectingAccountDashboard();
        return new AccountDetails(tool, test, user);
    }
}
