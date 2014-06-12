package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.FraudlockSubscriberConfirmationCommon;

public class FraudlockSubscriberConfirmation extends FraudlockSubscriberConfirmationCommon {

    public FraudlockSubscriberConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public FraudlockSubscriberFraudlockSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new FraudlockSubscriberFraudlockSuccessful(tool, test, user);
    }
}