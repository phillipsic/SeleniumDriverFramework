/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyPaymentMethodCommon;

/**
 * 
 * @author iphilli
 */
public class ModifyPaymentMethod extends ModifyPaymentMethodCommon {

    public ModifyPaymentMethod(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AccountDetails clickOk() throws Exception {

        super.clickOk();
        return new AccountDetails(driver);
    }
}
