package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CustomerAcquisitionCustomerDataReviewCommon;

public class CustomerAcquisitionCustomerDataReview extends CustomerAcquisitionCustomerDataReviewCommon {

    public CustomerAcquisitionCustomerDataReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public UpdateAccountBillingAddressInformations clickContinue() throws Exception {

        super.clickContinue();
        return new UpdateAccountBillingAddressInformations(tool, test, user);
    }

    @Override
    public UpdateAccountContactInformations clickEditCustomerIdentityAndContact() throws Exception {

        super.clickEditCustomerIdentityAndContact();
        return new UpdateAccountContactInformations(tool, test, user);
    }

    @Override
    public UpdateAdministrativeAccountInformation clickBillingInformationEditButton() throws Exception {
        super.clickBillingInformationEditButton();
        return new UpdateAdministrativeAccountInformation(tool, test, user);
    }

    @Override
    public UpdateAccountBillingAddressInformations clickEditAddressDetail() throws Exception {

        super.clickEditAddressDetail();
        return new UpdateAccountBillingAddressInformations(tool, test, user);
    }
}
