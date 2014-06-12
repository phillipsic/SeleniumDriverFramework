/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SearchOrdersCommon;

public class SearchOrders extends SearchOrdersCommon {

    public SearchOrders(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
	public WorkSpace clickHomeMenu() throws Exception {
        super.clickHomeMenu();
        return new WorkSpace(tool, test, user);
    }

}
