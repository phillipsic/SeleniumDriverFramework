/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.LockLoginCommon;

/**
 * 
 * @author iphilli
 */
public class LockLogin extends LockLoginCommon {

    public LockLogin(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public LoginInformation clickOk() throws Exception {

        super.clickOk();
        return new LoginInformation(driver);
    }
}
