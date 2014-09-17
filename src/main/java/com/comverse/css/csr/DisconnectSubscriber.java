package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.DisconnectSubscriberCommon;

public class DisconnectSubscriber extends DisconnectSubscriberCommon {

    public DisconnectSubscriber(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public DisconnectSubscriberDisconnectionSuccessful clickConfirm() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        super.clickConfirm();
        return new DisconnectSubscriberDisconnectionSuccessful(tool, test, user);
    }

}