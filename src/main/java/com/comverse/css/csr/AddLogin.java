package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddLoginCommon;

public class AddLogin extends AddLoginCommon {

    public AddLogin(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public PersonManagement clickContinue() throws Exception {
        super.clickContinue();
        return new PersonManagement(driver);
    }
}
