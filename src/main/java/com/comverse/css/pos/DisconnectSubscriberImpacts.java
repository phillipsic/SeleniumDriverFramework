package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.DisconnectSubscriberImpactsCommon;

public class DisconnectSubscriberImpacts extends DisconnectSubscriberImpactsCommon {

    public DisconnectSubscriberImpacts(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public DisconnectSubscriber clickConfirm() throws Exception {
        super.clickConfirm();
        return new DisconnectSubscriber(tool, test, user);
    }
}