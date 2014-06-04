package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ReconfigureBalanceConfirmCommon;

public class ReconfigureBalanceConfirm extends ReconfigureBalanceConfirmCommon {

    public ReconfigureBalanceConfirm(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    public ViewBalance clickBack() throws Exception {

        super.clickBack();
        return new ViewBalance(driver);
    }

}
