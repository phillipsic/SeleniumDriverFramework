/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ConfirmChangePasswordCommon;

/**
 * 
 * @author iphilli
 */
public class ConfirmChangePassword extends ConfirmChangePasswordCommon {

    public ConfirmChangePassword(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ChangeLoginPassword clickOk() throws Exception {

        super.clickOk();
        return new ChangeLoginPassword(driver);
    }
}
