/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ModifyAccountAttributesCommon;

public class ModifyAccountAttributes extends ModifyAccountAttributesCommon {

    public ModifyAccountAttributes(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public RequestSubmission clickModifyAttributes() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        super.clickModifyAttributes();
        return new RequestSubmission(tool, test, user);
    }

    @Override
    public void enterSecurityNumber(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.enterStringUsingXPath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div/input", value);
    }

    @Override
    public String getSecurityNumber() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getAttributeUsingXpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div/input", "value");
    }
}
