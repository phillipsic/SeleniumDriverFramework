package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ChangePasswordCommon;

public class ChangePassword extends ChangePasswordCommon {

    public ChangePassword(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ModifyLoginPassword clickChange() throws Exception {

        super.clickChange();
        return new ModifyLoginPassword(driver);
    }
}
