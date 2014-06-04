/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.NewMemberLegalAddressCommon;

/**
 * 
 * @author iphilli
 */
public class NewMemberLegalAddress extends NewMemberLegalAddressCommon {

    public NewMemberLegalAddress(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public Login clickContinue() throws Exception {

        super.clickContinue();
        return new Login(driver);
    }
}
