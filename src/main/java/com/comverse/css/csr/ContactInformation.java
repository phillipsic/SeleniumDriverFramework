/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ContactInformationCommon;

/**
 *
 * @author iphilli
 */
public class ContactInformation extends ContactInformationCommon {

    public ContactInformation(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public LoginInformation clickViewLoginInformationLink() throws Exception {

        super.clickViewLoginInformationLink();
        return new LoginInformation(driver);
    }

    @Override
    public MoveMember clickMoveMember() throws Exception {

        super.clickMoveMember();
        return new MoveMember(driver);
    }

    @Override
    public ModifyEmployeeContact clickModifyContact() throws Exception {

        super.clickModifyContact();
        return new ModifyEmployeeContact(driver);
    }

    @Override
    public ContactInformation clickUserInformation() throws Exception {
        super.clickUserInformation();
        return new ContactInformation(driver);
    }
}
