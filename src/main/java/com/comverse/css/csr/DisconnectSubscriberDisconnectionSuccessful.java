package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.DisconnectSubscriberDisconnectionSuccessfulCommon;

public class DisconnectSubscriberDisconnectionSuccessful extends DisconnectSubscriberDisconnectionSuccessfulCommon {

    public DisconnectSubscriberDisconnectionSuccessful(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public SubscriberDetails clickOK() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        super.clickOK();
        return new SubscriberDetails(tool, test, user);
    }
}