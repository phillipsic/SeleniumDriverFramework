/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SearchRequestsCommon;

public class SearchRequests extends SearchRequestsCommon {

    public SearchRequests(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public SearchOrders clickSearchOrders() throws Exception {

        super.clickSearchOrders();
        return new SearchOrders(tool, test, user);
    }
}
