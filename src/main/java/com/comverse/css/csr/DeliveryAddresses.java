/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.DeliveryAddressesCommon;

public class DeliveryAddresses extends DeliveryAddressesCommon {

    public DeliveryAddresses(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AddDeliveryAddress clickAdd() throws Exception {

        super.clickAdd();
        return new AddDeliveryAddress(driver);
    }

    @Override
    public ModifyDeliveryAddress clickModify() throws Exception {

        super.clickModify();
        return new ModifyDeliveryAddress(driver);
    }

    @Override
    public RemoveDeliveryAddress clickRemove() throws Exception {

        super.clickRemove();
        return new RemoveDeliveryAddress(driver);
    }

    @Override
    public DeliveryAddresses searchWithWildCard(String wildcard) throws Exception {
        super.searchWithWildCard(wildcard);
        return new DeliveryAddresses(driver);
    }
}
