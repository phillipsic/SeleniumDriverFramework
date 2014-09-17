package com.comverse.cls;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CLSMenu extends Main {

    public CLSMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickSignOut() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("$azn666_label");

    }
}
