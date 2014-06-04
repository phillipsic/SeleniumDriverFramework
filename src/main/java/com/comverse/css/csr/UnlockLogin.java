/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.UnlockLoginCommon;

/**
 * 
 * @author iphilli
 */
public class UnlockLogin extends UnlockLoginCommon {

    public UnlockLogin(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public UnlockDone clickConfirm() throws Exception {

        super.clickConfirm();
        return new UnlockDone(driver);
    }

}
