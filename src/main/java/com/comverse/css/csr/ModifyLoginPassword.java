/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyLoginPasswordCommon;

/**
 * 
 * @author iphilli
 */
public class ModifyLoginPassword extends ModifyLoginPasswordCommon {

    public ModifyLoginPassword(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {

        super.clickLogout();
        return new MyshapeCSRPortal(driver);
    }
}
