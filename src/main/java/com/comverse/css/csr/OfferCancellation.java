/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.OfferCancellationCommon;

/**
 * 
 * @author iphilli
 */
public class OfferCancellation extends OfferCancellationCommon {

    public OfferCancellation(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public AccountDetails clickOk() throws Exception {

        super.clickOk();
        return new AccountDetails(driver);
    }
}
