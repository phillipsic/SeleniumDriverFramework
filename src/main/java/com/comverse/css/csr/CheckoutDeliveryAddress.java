/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.CheckoutDeliveryAddressCommon;

/**
 * 
 * @author iphilli
 */
public class CheckoutDeliveryAddress extends CheckoutDeliveryAddressCommon {

    public CheckoutDeliveryAddress(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public CheckoutReview clickNextPage() throws Exception {
        super.clickNextPage();
        return new CheckoutReview(driver);
    }
}
