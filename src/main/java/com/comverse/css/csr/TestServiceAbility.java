package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.TestServiceAbilityCommon;

public class TestServiceAbility extends TestServiceAbilityCommon {

    public TestServiceAbility(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public Shopping clickOK() throws Exception {
        super.clickOK();
        return new Shopping(tool, test, user);
    }
}