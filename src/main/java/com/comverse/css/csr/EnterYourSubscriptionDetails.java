/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.EnterYourSubscriptionDetailsCommon;

/**
 *
 * @author iphilli
 */
public class EnterYourSubscriptionDetails extends EnterYourSubscriptionDetailsCommon {

    public EnterYourSubscriptionDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SelectOffersForYourSubscriber clickContinue() throws Exception {
        super.clickContinue();
        return new SelectOffersForYourSubscriber(driver);
    }

}
