package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.UnlockSubscriberConfirmationCommon;

public class UnlockSubscriberConfirmation extends UnlockSubscriberConfirmationCommon {

    public UnlockSubscriberConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public UnlockSubscriberUnlockSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new UnlockSubscriberUnlockSuccessful(tool, test, user);
    }
}