package com.comverse.css.csr;

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
}
