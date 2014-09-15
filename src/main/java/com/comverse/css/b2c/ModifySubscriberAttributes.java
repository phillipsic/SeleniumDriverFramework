/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifySubscriberAttributes extends B2CMenu {

    public ModifySubscriberAttributes(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Subscriber Attributes";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public RequestSubmission clickModifyAttributes() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value= 'Modify Attributes']");
        return new RequestSubmission(tool, test, user);
    }

    public void selectLanguage(String language) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + language + ")");
        tool.selectVisibleTextByID("p-param-L4:80000", language);

    }

    public String getLanguage() throws Exception {
        test.writeInLog(Common.getMethodName());
        String language = tool.getSelectedTextByID("p-param-L4:80000");
        return language;
    }

    public SubscriberDetail clickCancel() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value= 'Cancel']");
        return new SubscriberDetail(tool, test, user);
    }

}
