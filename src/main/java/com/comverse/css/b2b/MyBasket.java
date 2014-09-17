/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.MyBasketCommon;

public class MyBasket extends MyBasketCommon {

    public MyBasket(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public Shopping changePrimaryOffer() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.changePrimaryOffer();
        return new Shopping(tool, test, user);
    }

    @Override
    public MyshapeBusiness clickLogout() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickLogout();
        return new MyshapeBusiness(tool, test, user);
    }

    @Override
    public ParkTheCurrentBasket clickParkBasket() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickParkBasket();
        return new ParkTheCurrentBasket(tool, test, user);
    }

    @Override
    public CheckoutReview clickCheckOut() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickCheckOut();
        return new CheckoutReview(tool, test, user);
    }

    @Override
    public CheckoutDeliveryAddress clickCheckOutWithGoods() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickCheckOutWithGoods();
        return new CheckoutDeliveryAddress(tool, test, user);
    }

    @Override
    public Shopping clickContinueShopping() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickContinueShopping();
        return new Shopping(tool, test, user);
    }

    @Override
    public RemoveSelection removeFirstItemFromBasket() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.removeFirstItemFromBasket();
        return new RemoveSelection(tool, test, user);
    }

    @Override
    public RemoveBasket clickClear() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickClear();
        return new RemoveBasket(tool, test, user);
    }
}
