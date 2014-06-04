package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RegisterPrepaymentCommon;

public class RegisterPrepayment extends RegisterPrepaymentCommon {

    public RegisterPrepayment(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public RegisterPrepaymentConfirm clickConfirm() throws Exception {

        super.clickConfirm();
        return new RegisterPrepaymentConfirm(driver);
    }
}
