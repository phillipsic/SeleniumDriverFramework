package com.comverse.upm.common;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;
import com.comverse.upm.upmPages.UpmProcessPage;

public class CommonMenu extends Main {

    public Account account;
    String uniqueTimeStamp;

    public CommonMenu(AutomationTool tool, Test test, User user) throws Exception {
        this.tool = tool;
        this.test = test;
        this.user = user;
        uniqueTimeStamp = Common.generateTimeStamp();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public UpmProcessPage clickProcess() throws Exception {
        tool.clickUsingXPath("//li[5]/a/span");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UpmProcessPage(tool, test, user);
    }

}
