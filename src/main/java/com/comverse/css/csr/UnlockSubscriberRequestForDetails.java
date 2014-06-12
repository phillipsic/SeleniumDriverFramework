package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.UnlockSubscriberRequestForDetailsCommon;

public class UnlockSubscriberRequestForDetails extends UnlockSubscriberRequestForDetailsCommon {

    public UnlockSubscriberRequestForDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public UnlockSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new UnlockSubscriberConfirmation(tool, test, user);
    }
}