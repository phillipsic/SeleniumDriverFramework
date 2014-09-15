/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.MyshapeCommon;

public class MyshapeCSRPortal extends MyshapeCommon {

    public MyshapeCSRPortal(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Myshape CSR Portal";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public WorkSpace clickChange() throws Exception {
        tool.clickUsingXPath("//input[@value='Change']");
        return new WorkSpace(tool, test, user);
    }

    public HomePageBackOffice clickChangePassword() throws Exception {
        tool.clickUsingXPath("//input[@value='Change']");
        return new HomePageBackOffice(tool, test, user);
    }

    @Override
    public WorkSpace clickContinue() throws Exception {
        super.clickContinue();
        return new WorkSpace(tool, test, user);
    }

}
