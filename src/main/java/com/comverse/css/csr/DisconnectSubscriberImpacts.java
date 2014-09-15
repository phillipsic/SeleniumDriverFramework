package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.DisconnectSubscriberImpactsCommon;

public class DisconnectSubscriberImpacts extends DisconnectSubscriberImpactsCommon {

    public DisconnectSubscriberImpacts(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public DisconnectSubscriber clickConfirm() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickConfirm();
        return new DisconnectSubscriber(tool, test, user);
    }
}