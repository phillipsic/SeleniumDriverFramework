/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;
import com.comverse.css.commonpages.SubscribeToRechargePromotionalOffersCommon;

public class SubscribeToRechargePromotionalOffers extends SubscribeToRechargePromotionalOffersCommon {

    public SubscribeToRechargePromotionalOffers(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public MyBasket clickContinue() throws Exception {
        super.clickContinue();
        return new MyBasket(driver);
    }

}
