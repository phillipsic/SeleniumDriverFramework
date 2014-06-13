/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyAccountAttributesCommon;

public class ModifyAccountAttributes extends ModifyAccountAttributesCommon {

    public ModifyAccountAttributes(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public RequestSubmission clickModifyAttributes() throws Exception {

        super.clickModifyAttributes();
        return new RequestSubmission(tool, test, user);
    }

    @Override
    public void enterSecurityNumber(String value) throws Exception {
        
        tool.enterStringUsingXPath(tool, "//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div/input", value);
    }

    @Override
    public String getSecurityNumber() throws Exception {

        return tool.driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div/input")).getAttribute("value");
    }

}
