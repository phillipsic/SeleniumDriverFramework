package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ServiceConnectionDetailsCommon;

public class ServiceConnectionDetails extends ServiceConnectionDetailsCommon {

    public ServiceConnectionDetails(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public MyBasket clickOk() throws Exception {

        super.clickOk();
        return new MyBasket(tool, test, user);
    }

    @Override
    public SwapImpact clickOkExpectingSwapImpact() throws Exception {
        super.clickOkExpectingSwapImpact();
        return new SwapImpact(tool, test, user);
    }
}
