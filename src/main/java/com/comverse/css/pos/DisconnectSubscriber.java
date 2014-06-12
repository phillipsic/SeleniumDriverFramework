package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.DisconnectSubscriberCommon;

public class DisconnectSubscriber extends DisconnectSubscriberCommon {

    public DisconnectSubscriber(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public DisconnectSubscriberDisconnectionSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new DisconnectSubscriberDisconnectionSuccessful(tool, test, user);
    }
}