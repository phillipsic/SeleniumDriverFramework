package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CheckoutConfirmationCommon;

public class CheckoutConfirmation extends CheckoutConfirmationCommon {

    public CheckoutConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public WorkSpace clickOk() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickOk();
        return new WorkSpace(tool, test, user);
    }

    @Override
    public AccountDetails clickAccounts() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickAccounts();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public AccountDetails clickOkExpectingAccountDashboard() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickOkExpectingAccountDashboard();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public SubscriberDetails clickOkExpectingSubscriberDashboard() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickOkExpectingSubscriberDashboard();
        return new SubscriberDetails(tool, test, user);
    }
}
