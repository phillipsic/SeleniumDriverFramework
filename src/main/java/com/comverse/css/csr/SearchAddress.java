/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SearchAddressCommon;

/**
 * 
 * @author gmaroth
 */
public class SearchAddress extends SearchAddressCommon {

    public SearchAddress(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SearchAddress clickOk() throws Exception {
        super.clickOk();
        return new SearchAddress(driver);
    }

    @Override
    public EnterIdentificationData clickSelectAddress() throws Exception {
        super.clickSelectAddress();
        return new EnterIdentificationData(driver);
    }
}
