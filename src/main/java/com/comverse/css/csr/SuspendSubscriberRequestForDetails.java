package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SuspendSubscriberRequestForDetailsCommon;

public class SuspendSubscriberRequestForDetails extends SuspendSubscriberRequestForDetailsCommon {

    public SuspendSubscriberRequestForDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public SuspendSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new SuspendSubscriberConfirmation(tool, test, user);
    }
}