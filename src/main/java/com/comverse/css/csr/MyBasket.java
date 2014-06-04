/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.MyBasketCommon;

/**
 * 
 * @author iphilli
 */
public class MyBasket extends MyBasketCommon {

    public MyBasket(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public RemoveBasket clickClear() throws Exception {

        super.clickClear();
        return new RemoveBasket(driver);
    }

    @Override
    public RemoveSelection removeSecondItemFromBasket() throws Exception {

        super.removeSecondItemFromBasket();
        return new RemoveSelection(driver);
    }

    @Override
    public RemoveSelection removeFirstItemFromBasket() throws Exception {

        super.removeFirstItemFromBasket();
        return new RemoveSelection(driver);
    }

    @Override
    public Shopping changePrimaryOffer() throws Exception {

        super.changePrimaryOffer();
        return new Shopping(driver);
    }

    @Override
    public ServiceConnectionDetails clickFirstActionsIcon() throws Exception {

        super.clickFirstActionsIcon();
        return new ServiceConnectionDetails(driver);
    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {

        super.clickLogout();
        return new MyshapeCSRPortal(driver);
    }

    @Override
    public ParkTheCurrentBasket clickParkBasket() throws Exception {

        super.clickParkBasket();
        return new ParkTheCurrentBasket(driver);
    }

    @Override
    public CheckoutReview clickCheckOut() throws Exception {
        super.clickCheckOut();
        return new CheckoutReview(driver);
    }

    @Override
    public CheckoutDeliveryAddress clickCheckOutWithGoods() throws Exception {
        super.clickCheckOutWithGoods();
        return new CheckoutDeliveryAddress(driver);
    }

    @Override
    public Shopping clickContinueShopping() throws Exception {

        super.clickContinueShopping();
        return new Shopping(driver);
    }

    @Override
    public SelectOffersForYourSubscriber clickChangeSO() throws Exception {
        super.clickChangeSO();
        return new SelectOffersForYourSubscriber(driver);
    }

    @Override
    public SelectOffersForYourAccount clickAddAO() throws Exception {

        super.clickAddAO();
        return new SelectOffersForYourAccount(driver);
    }

    @Override
    public SelectOffersForYourSubscriber clickAddSO() throws Exception {
        super.clickAddSO();
        return new SelectOffersForYourSubscriber(driver);
    }
}
