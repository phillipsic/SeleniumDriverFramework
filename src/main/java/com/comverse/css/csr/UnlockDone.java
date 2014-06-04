/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.UnlockDoneCommon;

/**
 *
 * @author iphilli
 */
public class UnlockDone extends UnlockDoneCommon {

    public UnlockDone(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ModifyLoginPassword clickChangePassword() throws Exception {

        super.clickChangePassword();
        return new ModifyLoginPassword(driver);
    }
}
