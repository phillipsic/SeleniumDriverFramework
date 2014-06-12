/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CustomerAcquisitionCustomerDataReviewCommon;

public class CustomerAcquisitionCustomerDataReview extends CustomerAcquisitionCustomerDataReviewCommon {

    public CustomerAcquisitionCustomerDataReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public Shopping clickContinue() throws Exception {

        super.clickContinue();
        return new Shopping(tool, test, user);
    }

    @Override
    public UpdateAccountContactInformations clickEditCustomerIdentityAndContact() throws Exception {

        super.clickEditCustomerIdentityAndContact();
        return new UpdateAccountContactInformations(tool, test, user);
    }
}
