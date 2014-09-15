package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.FraudlockSubscriberRequestForDetailsCommon;

public class FraudlockSubscriberRequestForDetails extends FraudlockSubscriberRequestForDetailsCommon {

    public FraudlockSubscriberRequestForDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public FraudlockSubscriberConfirmation clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickContinue();
        return new FraudlockSubscriberConfirmation(tool, test, user);
    }
}