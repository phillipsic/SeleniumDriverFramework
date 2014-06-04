/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.NonVoucherRechargeReviewCommon;

/**
 * 
 * @author gmaroth
 */
public class NonVoucherRechargeReview extends NonVoucherRechargeReviewCommon {

    public NonVoucherRechargeReview(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public RechargeSubscriber confirmNonVoucherRecharge() throws Exception {

        super.confirmNonVoucherRecharge();
        return new RechargeSubscriber(driver);
    }

    @Override
    public RechargeSubscriber confirmNonVoucherRechargeByCreditCard() throws Exception {

        super.confirmNonVoucherRechargeByCreditCard();
        return new RechargeSubscriber(driver);
    }
}
