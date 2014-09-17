package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AccountBundleDistributionConfigurationCommon;

public class AccountBundleDistributionConfiguration extends AccountBundleDistributionConfigurationCommon {

    public AccountBundleDistributionConfiguration(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ConfigureContractDetails clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        super.clickContinue();
        return new ConfigureContractDetails(tool, test, user);
    }
}