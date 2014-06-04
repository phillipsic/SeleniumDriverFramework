/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyEmployeeContactConfirmationCommon;

/*public class ModifyEmployeeContactConfirmation {
    
}*/

public class ModifyEmployeeContactConfirmation extends ModifyEmployeeContactConfirmationCommon {

    public ModifyEmployeeContactConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ModifyEmpContactConf clickOk() throws Exception {
        super.clickOk();
        return new ModifyEmpContactConf(driver);
    }

}