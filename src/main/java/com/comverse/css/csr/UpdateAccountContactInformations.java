/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.UpdateAccountContactInformationsCommon;

public class UpdateAccountContactInformations extends UpdateAccountContactInformationsCommon {

    public UpdateAccountContactInformations(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickContinue() throws Exception {
        super.clickContinue();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }
}
