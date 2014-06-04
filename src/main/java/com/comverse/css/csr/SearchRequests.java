/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SearchRequestsCommon;

/**
 * 
 * @author iphilli
 */
public class SearchRequests extends SearchRequestsCommon {

    public SearchRequests(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public SearchOrders clickSearchOrders() throws Exception {

        super.clickSearchOrders();
        return new SearchOrders(driver);
    }
}
