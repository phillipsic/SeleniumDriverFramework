/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SupplementaryOfferDetailsCommon;

public class SupplementaryOfferDetails extends SupplementaryOfferDetailsCommon {

    public SupplementaryOfferDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MyBasket clickViewBasket() throws Exception {
        super.clickViewBasket();
        return new MyBasket(tool, test, user);
    }
}
