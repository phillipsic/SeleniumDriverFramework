package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SwapImpactCommon;

public class SwapImpact extends SwapImpactCommon {

    public SwapImpact(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public MyBasket clickOK() throws Exception {
        super.clickOK();
        return new MyBasket(tool, test, user);
    }

    @Override
    public ConfigureBalance clickOKExpectingConfigureBalance() throws Exception {
        super.clickOKExpectingConfigureBalance();
        return new ConfigureBalance(tool, test, user);
    }
}
