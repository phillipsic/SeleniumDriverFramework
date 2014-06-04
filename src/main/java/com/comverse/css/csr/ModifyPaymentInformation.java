/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyPaymentInformationCommon;

/**
 * 
 * @author iphilli
 */
public class ModifyPaymentInformation extends ModifyPaymentInformationCommon {

    public ModifyPaymentInformation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ModifyPaymentMethod clickModifyPaymentButton() throws Exception {

        super.clickModifyPaymentButton();
        return new ModifyPaymentMethod(driver);
    }
}
