/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyAccountAttributesCommon;

/**
 * 
 * @author iphilli
 */
public class ModifyAccountAttributes extends ModifyAccountAttributesCommon {

    public ModifyAccountAttributes(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public RequestSubmission clickModifyAttributes() throws Exception {

        super.clickModifyAttributes();
        return new RequestSubmission(driver);
    }
}
