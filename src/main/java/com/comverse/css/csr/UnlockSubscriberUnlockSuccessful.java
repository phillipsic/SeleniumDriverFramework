package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.UnlockSubscriberUnlockSuccessfulCommon;

public class UnlockSubscriberUnlockSuccessful extends UnlockSubscriberUnlockSuccessfulCommon {

    public UnlockSubscriberUnlockSuccessful(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public SubscriberDetails clickOK() throws Exception {
        super.clickOK();
        return new SubscriberDetails(tool, test, user);
    }
}