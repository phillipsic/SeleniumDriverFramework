/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SelectOffersForYourAccountCommon;

public class SelectOffersForYourAccount extends SelectOffersForYourAccountCommon {

    public SelectOffersForYourAccount(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public MyBasket clickContinueNoConfiguration() throws Exception {
        super.clickContinueNoConfiguration();
        return new MyBasket(driver);
    }

    @Override
    public AccountOfferDetails clickOfferDetail(String accountOfferName) throws Exception {
        super.clickOfferDetail(accountOfferName);
        return new AccountOfferDetails(driver);
    }
}
