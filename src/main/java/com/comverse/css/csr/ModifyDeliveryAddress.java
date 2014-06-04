/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyDeliveryAddressCommon;

public class ModifyDeliveryAddress extends ModifyDeliveryAddressCommon {

    public ModifyDeliveryAddress(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ModifyDeliveryAddressConfirmation clickOk() throws Exception {

        super.clickOk();
        return new ModifyDeliveryAddressConfirmation(driver);
    }
}
