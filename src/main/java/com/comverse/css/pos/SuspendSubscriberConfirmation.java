package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SuspendSubscriberConfirmationCommon;

public class SuspendSubscriberConfirmation extends SuspendSubscriberConfirmationCommon {

    public SuspendSubscriberConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public SuspendSubscriberSuspendSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new SuspendSubscriberSuspendSuccessful(tool, test, user);
    }
}