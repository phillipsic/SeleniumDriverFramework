/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyPaymentInformationCommon extends CommonMenu {

    public ModifyPaymentInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Payment Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setPaymentMethodDirectDebit() throws Exception {

        tool.clickUsingName("method");
    }

    public void setBankCode(String value) throws Exception {

        
        tool.enterStringUsingId("p-L1:1-L3:1360", value);
    }

    public void setBankAgencyCode(String value) throws Exception {

        
        tool.enterStringUsingId("p-L1:1-L3:1370", value);
    }

    public void setBankAccountNumber(String value) throws Exception {

        
        tool.enterStringUsingId("p-L1:1-L3:1380", value);
    }

    public void setOwnerlastName(String value) throws Exception {

        
        tool.enterStringUsingId("p-L1:1-L3:1270", value);
    }

    public ModifyPaymentMethodCommon clickModifyPaymentButton() throws Exception {

        tool.clickUsingXPath("//input[@value='Modify Payment Method']");
        return new ModifyPaymentMethodCommon(tool, test, user);
    }

    public String getBankCode() throws Exception {

        return tool.getAttributeUsingId("p-L1:1-L3:1360", "value");
    }

    public String getBankAgencyCode() throws Exception {

        return tool.getAttributeUsingId("p-L1:1-L3:1370", "value");
    }

    public String getBankAccountNumber() throws Exception {

        return tool.getAttributeUsingId("p-L1:1-L3:1380", "value");
    }
}
