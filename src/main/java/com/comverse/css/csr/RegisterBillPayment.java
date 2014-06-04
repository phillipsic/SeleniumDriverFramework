package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RegisterBillPaymentCommon;

public class RegisterBillPayment extends RegisterBillPaymentCommon {

    public RegisterBillPayment(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public RegisterBillPayment clickContinue() throws Exception {

        super.clickContinue();
        return new RegisterBillPayment(driver);
    }

    @Override
    public RegisterBillPayment clickConfirm() throws Exception {

        super.clickConfirm();
        return new RegisterBillPayment(driver);
    }

    @Override
    public ViewInvoices clickBackToInvoices() throws Exception {

        super.clickBackToInvoices();
        return new ViewInvoices(driver);
    }
}
