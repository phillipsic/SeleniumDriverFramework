/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RemoveDeliveryAddressCommon;

public class RemoveDeliveryAddress extends RemoveDeliveryAddressCommon {

    public RemoveDeliveryAddress(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public DeliveryAddresses clickOk() throws Exception {

        super.clickOk();
        return new DeliveryAddresses(driver);
    }
}
