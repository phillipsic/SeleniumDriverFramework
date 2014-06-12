/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ConfigureOffersCommon;

public class ConfigureOffers extends ConfigureOffersCommon {

    public ConfigureOffers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ConfigureBalance clickContinue() throws Exception {

        super.clickContinue();
        return new ConfigureBalance(tool, test, user);
    }

    @Override
    public SwapImpact clickContinueExpectingSwapImpact() throws Exception {
        super.clickContinueExpectingSwapImpact();
        return new SwapImpact(tool, test, user);
    }
}
