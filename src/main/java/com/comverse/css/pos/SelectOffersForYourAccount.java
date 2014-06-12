/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SelectOffersForYourAccountCommon;

public class SelectOffersForYourAccount extends SelectOffersForYourAccountCommon {

    public SelectOffersForYourAccount(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public MyBasket clickContinueNoConfiguration() throws Exception {
        super.clickContinueNoConfiguration();
        return new MyBasket(tool, test, user);
    }
}
