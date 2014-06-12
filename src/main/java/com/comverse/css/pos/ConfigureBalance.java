/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ConfigureBalanceCommon;

public class ConfigureBalance extends ConfigureBalanceCommon {

    public ConfigureBalance(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ServiceConnectionDetails clickContinueExpectingServiceConnectionDetails() throws Exception {

        super.clickContinueExpectingServiceConnectionDetails();
        return new ServiceConnectionDetails(tool, test, user);
    }

    @Override
    public MyBasket clickContinueExpectingMyBasket() throws Exception {

        super.clickContinueExpectingMyBasket();
        return new MyBasket(tool, test, user);
    }

    @Override
    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {

        super.setSpendingLimit(limitName, limitAmount);
    }

    @Override
    public ConfigureContractDetails clickContinueExpectingConfigureContractDetails() throws Exception {
        super.clickContinueExpectingConfigureContractDetails();
        return new ConfigureContractDetails(tool, test, user);
    }
}
