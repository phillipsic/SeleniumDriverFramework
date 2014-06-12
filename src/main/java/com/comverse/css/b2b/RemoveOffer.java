/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RemoveOfferCommon;

public class RemoveOffer extends RemoveOfferCommon {

    public RemoveOffer(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public OfferCancellation clickYes() throws Exception {

        super.clickYes();
        return new OfferCancellation(tool, test, user);
    }
}
