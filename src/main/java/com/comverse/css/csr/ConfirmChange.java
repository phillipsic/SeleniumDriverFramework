/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ConfirmChangeCommon;

/**
 * 
 * @author iphilli
 */
public class ConfirmChange extends ConfirmChangeCommon {

    public ConfirmChange(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public LoginInformation clickOK() throws Exception {

        super.clickOK();
        return new LoginInformation(driver);
    }
}
