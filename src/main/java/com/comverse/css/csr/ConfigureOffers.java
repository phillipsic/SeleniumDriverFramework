/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ConfigureOffersCommon;

/**
 * 
 * @author iphilli
 */
public class ConfigureOffers extends ConfigureOffersCommon {

    public ConfigureOffers(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ConfigureBalance clickContinue() throws Exception {

        super.clickContinue();
        return new ConfigureBalance(driver);
    }
    
    @Override
     public SwapImpact clickContinueExpectingSwapImpact() throws Exception {
       super.clickContinueExpectingSwapImpact();
        return new SwapImpact(driver);
    }
}
