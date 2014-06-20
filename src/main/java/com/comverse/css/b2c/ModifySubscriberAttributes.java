/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifySubscriberAttributes extends B2CMenu {

    public ModifySubscriberAttributes(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Subscriber Attributes";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RequestSubmission clickModifyAttributes() throws Exception {

        tool.clickUsingXPath("//input[@value= 'Modify Attributes']");
        return new RequestSubmission(tool, test, user);
    }

    public void selectLanguage(String language) throws Exception {

        tool.selectVisibleTextByID("p-param-L4:80000", language);

    }

    public String getLanguage() throws Exception {
        String language = tool.getSelectedTextByID("p-param-L4:80000");
        return language;
    }

    public SubscriberDetail clickCancel() throws Exception {

        tool.clickUsingXPath("//input[@value= 'Cancel']");
        return new SubscriberDetail(tool, test, user);
    }

}
