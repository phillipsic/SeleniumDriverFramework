package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RegisterPrepaymentConfirmCommon;

public class RegisterPrepaymentConfirm extends RegisterPrepaymentConfirmCommon {

    public RegisterPrepaymentConfirm(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AccountDetails clickBackToAccount() throws Exception {

        super.clickBackToAccount();
        return new AccountDetails(driver);
    }
}
