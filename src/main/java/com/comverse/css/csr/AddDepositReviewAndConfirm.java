/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddDepositReviewAndConfirmCommon;

/**
 * 
 * @author iphilli
 */
public class AddDepositReviewAndConfirm extends AddDepositReviewAndConfirmCommon {

    public AddDepositReviewAndConfirm(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AddDepositReviewAndConfirm clickConfirm() throws Exception {

        super.clickConfirm();
        return new AddDepositReviewAndConfirm(driver);
    }

    @Override
    public AccountDetails clickOk() throws Exception {

        super.clickOk();
        return new AccountDetails(driver);
    }

    @Override
    public AccountDeposits clickOkToViewDeposits() throws Exception {

        super.clickOkToViewDeposits();
        return new AccountDeposits(driver);
    }
}
