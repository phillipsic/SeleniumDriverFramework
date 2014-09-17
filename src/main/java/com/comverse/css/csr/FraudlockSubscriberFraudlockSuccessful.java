package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.FraudlockSubscriberFraudlockSuccessfulCommon;

public class FraudlockSubscriberFraudlockSuccessful extends FraudlockSubscriberFraudlockSuccessfulCommon {

    public FraudlockSubscriberFraudlockSuccessful(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public SubscriberDetails clickOK() throws Exception {
        super.clickOK();
        return new SubscriberDetails(tool, test, user);
    }
}