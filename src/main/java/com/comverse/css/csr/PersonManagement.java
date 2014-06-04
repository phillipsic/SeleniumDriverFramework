/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.PersonManagementCommon;

/**
 * 
 * @author iphilli
 */
public class PersonManagement extends PersonManagementCommon {

    public PersonManagement(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AddLogin clickActionsAddLoginForPerson(String personLastName) throws Exception {

        super.clickActionsAddLoginForPerson(personLastName);
        return new AddLogin(driver);
    }
}
