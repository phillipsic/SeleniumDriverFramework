/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SearchOrdersCommon;

/**
 * 
 * @author iphilli
 */
public class SearchOrders extends SearchOrdersCommon {

    public SearchOrders(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public WorkSpace clickHomeMenu() throws Exception {

        super.clickHomeMenu();
        return new WorkSpace(driver);
    }
}
