/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyContactInformationConfirmationCommon;

/**
 * 
 * @author gmaroth
 */
public class ModifyContactInformationConfirmation extends ModifyContactInformationConfirmationCommon {

    public ModifyContactInformationConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public RequestSubmission clickOk() throws Exception {
        super.clickOk();
        return new RequestSubmission(driver);
    }
}
