package com.comverse.upm.common;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;

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

}
