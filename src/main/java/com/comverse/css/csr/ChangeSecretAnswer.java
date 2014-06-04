/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ChangeSecretAnswerCommon;

/**
 * 
 * @author iphilli
 */
public class ChangeSecretAnswer extends ChangeSecretAnswerCommon {

    public ChangeSecretAnswer(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ConfirmNewSecretAnswer clickChangeSecretAnswer() throws Exception {

        super.clickChangeSecretAnswer();
        return new ConfirmNewSecretAnswer(driver);
    }
}
