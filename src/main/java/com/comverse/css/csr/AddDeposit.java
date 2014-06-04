/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddDepositCommon;

/**
 * 
 * @author iphilli
 */
public class AddDeposit extends AddDepositCommon {

    public AddDeposit(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public void setDepositType(String depositType) throws Exception {

        super.setDepositType(depositType);
    }

    @Override
    public void setBalance(String balanceName) throws Exception {

        super.setBalance(balanceName);
    }

    @Override
    public void setDepositAmount(String depositAmount) throws Exception {

        super.setDepositAmount(depositAmount);
    }

    @Override
    public void selectPaymentMethod() throws Exception {

        super.selectPaymentMethod();
    }

    @Override
    public AddDepositReviewAndConfirm clickContinue() throws Exception {

        super.clickContinue();
        return new AddDepositReviewAndConfirm(driver);
    }
}
