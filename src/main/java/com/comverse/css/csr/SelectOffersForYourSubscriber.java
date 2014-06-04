/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SelectOffersForYourSubscriberCommon;

public class SelectOffersForYourSubscriber extends SelectOffersForYourSubscriberCommon {

    public SelectOffersForYourSubscriber(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SupplementaryOfferDetails clickOfferDetail(String SOName) throws Exception {
        super.clickOfferDetail(SOName);
        return new SupplementaryOfferDetails(driver);
    }

    @Override
    public ConfigureOffers clickContinue() throws Exception {
        super.clickContinue();
        return new ConfigureOffers(driver);
    }

    @Override
    public MyBasket clickContinueExpectingMyBasket() throws Exception {

        super.clickContinueExpectingMyBasket();
        return new MyBasket(driver);
    }

    @Override
    public MyBasket clickCancel() throws Exception {
        super.clickCancel();
        return new MyBasket(driver);
    }

    @Override
    public SwapImpact clickContinueExpectingSwapImpact() throws Exception {

        super.clickContinueExpectingSwapImpact();
        return new SwapImpact(driver);
    }
    
    @Override
    public MyBasket clickViewBasket() throws Exception {
        super.clickViewBasket();
        return new MyBasket(driver);
    }
}