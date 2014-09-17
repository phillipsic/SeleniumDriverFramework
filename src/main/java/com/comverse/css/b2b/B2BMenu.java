/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class B2BMenu extends Main {

    public B2BMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public ContactInformation clickMyInformation() throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.clickUsingLinkText("mnu_INFO");
        return new ContactInformation(tool, test, user);
    }

    public MyshapeBusiness clickLogout() throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.clickUsingID("mnu_LOGOUT");
        return new MyshapeBusiness(tool, test, user);
    }
}
