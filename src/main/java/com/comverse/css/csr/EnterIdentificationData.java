/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.EnterIdentificationDataCommon;

/**
 * 
 * @author iphilli
 */
public class EnterIdentificationData extends EnterIdentificationDataCommon {

    public EnterIdentificationData(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public Shopping clickContinue() throws Exception {

        super.clickContinue();
        return new Shopping(driver);
    }

    @Override
    public SearchAddress clickSearchAddress() throws Exception {

        super.clickSearchAddress();
        return new SearchAddress(driver);
    }

}
