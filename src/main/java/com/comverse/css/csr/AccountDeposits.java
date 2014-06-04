/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AccountDepositsCommon;

/**
 * 
 * @author iphilli
 */
public class AccountDeposits extends AccountDepositsCommon {

    public AccountDeposits(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AddDeposit clickAdd() throws Exception {

        super.clickAdd();
        return new AddDeposit(driver);
    }

    @Override
    public AccountDetails clickBack() throws Exception {

        super.clickBack();
        return new AccountDetails(driver);
    }
}
