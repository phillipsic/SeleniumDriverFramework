/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RechargeWithVoucherCommon;

public class RechargeWithVoucher extends RechargeWithVoucherCommon {

    public RechargeWithVoucher(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public RechargeSubscriber clickContinue() throws Exception {
        super.clickContinue();
        return new RechargeSubscriber(driver);
    }
}
