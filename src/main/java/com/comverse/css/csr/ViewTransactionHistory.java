/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewTransactionHistoryCommon;

public class ViewTransactionHistory extends ViewTransactionHistoryCommon {

    public ViewTransactionHistory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewNRCHistory clickonNRCHistory() throws Exception {

        super.clickonNRCHistory();
        return new ViewNRCHistory(tool, test, user);
    }

    @Override
    public ViewRCHistory clickonRCHistory() throws Exception {

        super.clickonRCHistory();
        return new ViewRCHistory(tool, test, user);
    }

    @Override
    public ViewUsageHistory clickOnUsageHistory() throws Exception {

        super.clickOnUsageHistory();
        return new ViewUsageHistory(tool, test, user);
    }

    @Override
    public ViewMTRHistory clickonMTRHistory() throws Exception {

        super.clickonMTRHistory();
        return new ViewMTRHistory(tool, test, user);
    }
}
