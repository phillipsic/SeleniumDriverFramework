/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyDeliveryAddressConfirmationCommon;

public class ModifyDeliveryAddressConfirmation extends ModifyDeliveryAddressConfirmationCommon {

    public ModifyDeliveryAddressConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public DeliveryAddresses clickOk() throws Exception {

        super.clickOk();
        return new DeliveryAddresses(driver);
    }
}
