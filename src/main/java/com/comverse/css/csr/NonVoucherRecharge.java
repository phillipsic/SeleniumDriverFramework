/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.NonVoucherRechargeCommon;

/**
 * 
 * @author gmaroth
 */
public class NonVoucherRecharge extends NonVoucherRechargeCommon {

    public NonVoucherRecharge(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public NonVoucherRechargeReview nonVoucherRechargeByCheck(String rechargeAmount) throws Exception {

        super.nonVoucherRechargeByCheck(rechargeAmount);
        return new NonVoucherRechargeReview(driver);
    }

    @Override
    public NonVoucherRechargeReview clickSelect() throws Exception {

        super.clickSelect();
        return new NonVoucherRechargeReview(driver);
    }

    @Override
    public NonVoucherRechargeReview clickContinueExpectingNonVoucherRechargeReview() throws Exception {
        super.clickContinueExpectingNonVoucherRechargeReview();
        return new NonVoucherRechargeReview(driver);
    }
}
