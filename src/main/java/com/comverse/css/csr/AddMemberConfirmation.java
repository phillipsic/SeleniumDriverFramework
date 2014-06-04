package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddMemberConfirmationCommon;

public class AddMemberConfirmation extends AddMemberConfirmationCommon {

    public AddMemberConfirmation(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public AddMember clickOk() throws Exception {

        super.clickOk();
        return new AddMember(driver);
    }
}
