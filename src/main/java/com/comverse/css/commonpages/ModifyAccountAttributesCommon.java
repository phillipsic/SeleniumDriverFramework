/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyAccountAttributesCommon extends CommonMenu {

    public ModifyAccountAttributesCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Account Attributes";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterSecurityNumber(String value) throws Exception {

        tool.enterStringUsingXPath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[2]/input", value);
    }

    public void enterPurchaseOrder(String value) throws Exception {

        tool.enterStringUsingXPath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[3]/input", value);
    }

    public void enterSalesCode(String value) throws Exception {

        tool.enterStringUsingXPath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[4]/input", value);
    }

    public void enterSecurityWord(String value) throws Exception {

        tool.enterStringUsingXPath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[5]/input", value);
    }

    public void enterSICWord(String value) throws Exception {

        tool.enterStringUsingXPath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[6]/input", value);
    }

    public RequestSubmissionCommon clickModifyAttributes() throws Exception {

        tool.clickUsingXPath("//input[@value='Modify Attributes']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RequestSubmissionCommon(tool, test, user);
    }

    public String getSecurityNumber() throws Exception {
        return tool.getAttributeUsingXpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[2]/input", "value");
    }

    public String getPurchaseOrder() throws Exception {
        return tool.getAttributeUsingXpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[3]/input", "value");
    }

    public String getSalesCode() throws Exception {
        return tool.getAttributeUsingXpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[4]/input", "value");
    }

    public String getSecurityWord() throws Exception {
        return tool.getAttributeUsingXpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[5]/input", "value");
    }

    public String getSICWord() throws Exception {
        return tool.getAttributeUsingXpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[6]/input", "value");
    }
}
