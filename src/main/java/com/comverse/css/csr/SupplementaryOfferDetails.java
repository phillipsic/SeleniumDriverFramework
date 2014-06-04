/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SupplementaryOfferDetailsCommon;

public class SupplementaryOfferDetails extends SupplementaryOfferDetailsCommon {

    public SupplementaryOfferDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public MyBasket clickViewBasket() throws Exception {
        super.clickViewBasket();
        return new MyBasket(driver);
    }
}
