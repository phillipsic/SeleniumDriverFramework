/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewTransactionHistoryCommon;

public class ViewTransactionHistory extends ViewTransactionHistoryCommon {

    public ViewTransactionHistory(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    public ViewNRCHistory clickonNRCHistory() throws Exception {

        super.clickonNRCHistory();
        return new ViewNRCHistory(driver);
    }

    @Override
    public ViewRCHistory clickonRCHistory() throws Exception {

        super.clickonRCHistory();
        return new ViewRCHistory(driver);
    }

    @Override
    public ViewUsageHistory clickOnUsageHistory() throws Exception {

        super.clickOnUsageHistory();
        return new ViewUsageHistory(driver);
    }

    @Override
    public ViewMTRHistory clickonMTRHistory() throws Exception {

        super.clickonMTRHistory();
        return new ViewMTRHistory(driver);
    }
}
