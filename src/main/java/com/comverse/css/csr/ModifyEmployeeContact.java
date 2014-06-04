/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyEmployeeContactCommon;

public class ModifyEmployeeContact extends ModifyEmployeeContactCommon {

    public ModifyEmployeeContact(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ModifyEmployeeContactConfirmation clickOk() throws Exception {
        super.clickOk();
        return new ModifyEmployeeContactConfirmation(driver);
    }

}
