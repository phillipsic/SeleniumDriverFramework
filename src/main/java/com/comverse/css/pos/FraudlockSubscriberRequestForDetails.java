package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.FraudlockSubscriberRequestForDetailsCommon;

public class FraudlockSubscriberRequestForDetails extends FraudlockSubscriberRequestForDetailsCommon {

    public FraudlockSubscriberRequestForDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public FraudlockSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new FraudlockSubscriberConfirmation(tool, test, user);
    }
}