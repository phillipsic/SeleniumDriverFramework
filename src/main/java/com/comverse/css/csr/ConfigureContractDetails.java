package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ConfigureContractDetailsCommon;

public class ConfigureContractDetails extends ConfigureContractDetailsCommon {

    public ConfigureContractDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MyBasket clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickContinue();
        return new MyBasket(tool, test, user);
    }

    @Override
    public ConfigureBalance clickContinueExpectingConfigureBalance() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickContinueExpectingConfigureBalance();
        return new ConfigureBalance(tool, test, user);
    }
}
