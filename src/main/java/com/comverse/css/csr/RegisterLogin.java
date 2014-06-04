/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RegisterLoginCommon;

/**
 * 
 * @author iphilli
 */
public class RegisterLogin extends RegisterLoginCommon {

    public RegisterLogin(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public RegisterLogin clickRegisterLoginContinue() throws Exception {

        super.clickRegisterLoginContinue();
        return new RegisterLogin(driver);
    }

    public LoginInformation clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new LoginInformation(driver);
    }
    
       public ViewHierarchy clickOk() throws Exception {

        super.clickOk();
        return new ViewHierarchy(driver);
    }
}
