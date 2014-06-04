package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddMemberCommon;

public class AddMember extends AddMemberCommon {

    public AddMember(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ViewHierarchy clickOk() throws Exception {

        super.clickOk();
        return new ViewHierarchy(driver);
    }
}
