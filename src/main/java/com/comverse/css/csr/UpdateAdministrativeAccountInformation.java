/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.UpdateAdministrativeAccountInformationCommon;

public class UpdateAdministrativeAccountInformation extends UpdateAdministrativeAccountInformationCommon {

    public UpdateAdministrativeAccountInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickConfirm() throws Exception {

        super.clickConfirm();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

}
