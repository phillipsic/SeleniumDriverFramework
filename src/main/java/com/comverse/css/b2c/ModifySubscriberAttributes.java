/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifySubscriberAttributes extends B2CMenu {

    public ModifySubscriberAttributes(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Subscriber Attributes";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RequestSubmission clickModifyAttributes() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value= 'Modify Attributes']");
        return new RequestSubmission(tool, test, user);
    }

    public void selectLanguage(String language) throws Exception {

        new Select(tool.searchUsingID(tool, "p-param-L4:80000")).selectByVisibleText(language);

    }

    public String getLanguage() throws Exception {

        String language = new Select(tool.searchUsingID(tool, "p-param-L4:80000")).getFirstSelectedOption().getText();
        return language;
    }

    public SubscriberDetail clickCancel() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value= 'Cancel']");
        return new SubscriberDetail(tool, test, user);
    }

}
