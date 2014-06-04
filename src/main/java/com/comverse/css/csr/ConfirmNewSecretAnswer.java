/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ConfirmNewSecretAnswerCommon;

/**
 * 
 * @author iphilli
 */
public class ConfirmNewSecretAnswer extends ConfirmNewSecretAnswerCommon {

    public ConfirmNewSecretAnswer(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ConfirmChange clickOK() throws Exception {

        super.clickOK();
        return new ConfirmChange(driver);
    }
}
