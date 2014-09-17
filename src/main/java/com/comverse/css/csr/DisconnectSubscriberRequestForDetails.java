package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.DisconnectSubscriberRequestForDetailsCommon;

public class DisconnectSubscriberRequestForDetails extends DisconnectSubscriberRequestForDetailsCommon {

    public DisconnectSubscriberRequestForDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public DisconnectSubscriberImpacts clickContinue() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickContinue();
        return new DisconnectSubscriberImpacts(tool, test, user);
    }
}