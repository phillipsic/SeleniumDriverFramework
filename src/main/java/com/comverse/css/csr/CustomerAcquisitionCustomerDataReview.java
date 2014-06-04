package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.CustomerAcquisitionCustomerDataReviewCommon;

public class CustomerAcquisitionCustomerDataReview extends CustomerAcquisitionCustomerDataReviewCommon {

    public CustomerAcquisitionCustomerDataReview(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public Shopping clickContinue() throws Exception {

        super.clickContinue();
        return new Shopping(driver);
    }

    @Override
    public UpdateAccountContactInformations clickEditCustomerIdentityAndContact() throws Exception {

        super.clickEditCustomerIdentityAndContact();
        return new UpdateAccountContactInformations(driver);
    }

    @Override
    public UpdateAdministrativeAccountInformation clickBillingInformationEditButton() throws Exception {
        super.clickBillingInformationEditButton();
        return new UpdateAdministrativeAccountInformation(driver);
    }
}
