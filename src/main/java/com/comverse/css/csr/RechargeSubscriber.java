/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RechargeSubscriberCommon;

/**
 * 
 * @author gmaroth
 */
public class RechargeSubscriber extends RechargeSubscriberCommon {

    public RechargeSubscriber(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ViewBalance clickViewBalances() throws Exception {

        super.clickViewBalances();
        return new ViewBalance(driver);
    }
}
