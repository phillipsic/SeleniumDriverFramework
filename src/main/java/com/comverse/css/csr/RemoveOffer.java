/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RemoveOfferCommon;

/**
 * 
 * @author iphilli
 */
public class RemoveOffer extends RemoveOfferCommon {

    public RemoveOffer(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public OfferCancellation clickYes() throws Exception {

        super.clickYes();
        return new OfferCancellation(driver);
    }
}
