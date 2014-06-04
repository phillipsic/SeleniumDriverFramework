/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyContactInformationCommon;

/**
 * 
 * @author iphilli
 */
public class ModifyContactInformation extends ModifyContactInformationCommon {

    public ModifyContactInformation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ModifyContactInformationConfirmation clickOk() throws Exception {
        super.clickOk();
        return new ModifyContactInformationConfirmation(driver);
    }
}
