/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.MyBasketCommon;

public class MyBasket extends MyBasketCommon {

    public MyBasket(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public CheckoutReview clickCheckOut() throws Exception {
        super.clickCheckOut();
        return new CheckoutReview(tool, test, user);
    }

    @Override
    public ServiceConnectionDetails clickFirstActionsIcon() throws Exception {

        super.clickFirstActionsIcon();
        return new ServiceConnectionDetails(tool, test, user);
    }

    @Override
    public ParkTheCurrentBasket clickParkBasket() throws Exception {

        super.clickParkBasket();
        return new ParkTheCurrentBasket(tool, test, user);
    }

    @Override
    public Shopping changePrimaryOffer() throws Exception {

        super.changePrimaryOffer();
        return new Shopping(tool, test, user);
    }

    @Override
    public RemoveSelection removeSecondItemFromBasket() throws Exception {

        super.removeSecondItemFromBasket();
        return new RemoveSelection(tool, test, user);
    }

    @Override
    public RemoveSelection removeFirstItemFromBasket() throws Exception {

        super.removeFirstItemFromBasket();
        return new RemoveSelection(tool, test, user);
    }

    @Override
    public RemoveBasket clickClear() throws Exception {

        super.clickClear();
        return new RemoveBasket(tool, test, user);
    }

    @Override
    public MyShapeChannel clickLogout() throws Exception {
        super.clickLogout();
        return new MyShapeChannel(tool, test, user);
    }

    @Override
    public Shopping clickContinueShopping() throws Exception {

        super.clickContinueShopping();
        return new Shopping(tool, test, user);
    }

    @Override
    public CheckoutDeliveryAddress clickCheckOutWithGoods() throws Exception {
        super.clickCheckOutWithGoods();
        return new CheckoutDeliveryAddress(tool, test, user);
    }

    @Override
    public SelectOffersForYourAccount clickAddAO() throws Exception {

        super.clickAddAO();
        return new SelectOffersForYourAccount(tool, test, user);
    }

    @Override
    public SelectOffersForYourSubscriber clickAddSO() throws Exception {
        super.clickAddSO();
        return new SelectOffersForYourSubscriber(tool, test, user);
    }

}
