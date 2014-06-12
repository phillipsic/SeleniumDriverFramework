package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SwapBundleCommon;

public class SwapBundle extends SwapBundleCommon {

    public SwapBundle(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AccountBundleDistributionConfiguration clickContinue() throws Exception {
        super.clickContinue();
        return new AccountBundleDistributionConfiguration(tool, test, user);
    }

}