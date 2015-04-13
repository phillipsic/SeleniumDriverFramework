package com.company.mercurytours.pages;

import com.framework.app.common.Common;
import com.framework.common.AutomationTool;
import com.framework.common.Main;
import com.framework.common.TestDetails;
import com.framework.common.User;

/**
 *
 * @author Ian Phillps
 */
public class MercuryToursMenu extends Main {

    public MercuryToursMenu(AutomationTool tool, TestDetails test, User user) throws Exception {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }
    
    public WelcomeMercuryTours clickHomeLink() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Home");
        return new WelcomeMercuryTours(tool, test, user);
    }
    
    public RegisterMercuryTours clickRegisterLink() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("REGISTER");
        return new RegisterMercuryTours(tool, test, user);
    }

}
