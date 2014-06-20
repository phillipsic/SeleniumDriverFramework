package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.DisconnectAccountCommon;

public class DisconnectAccount extends DisconnectAccountCommon {

    public DisconnectAccount(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public void clickCheckBoxUnlockNow() throws Exception {
        tool.clickUsingID("disconnectNow");
    }

    @Override
    public void setAnnotation(String annotation) throws Exception {

        
        tool.enterStringUsingId("annotation", annotation);
    }

    @Override
    public DisconnectAccount clickContinue() throws Exception {
        super.clickContinue();
        return new DisconnectAccount(tool, test, user);
    }

    @Override
    public DisconnectAccount clickContinueOnImpacts() throws Exception {
        super.clickContinueOnImpacts();
        return new DisconnectAccount(tool, test, user);
    }

    @Override
    public AccountDetails clickOk() throws Exception {
        super.clickOk();
        return new AccountDetails(tool, test, user);
    }
}