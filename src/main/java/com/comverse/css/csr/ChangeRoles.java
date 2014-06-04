/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ChangeRolesCommon;

/**
 * 
 * @author iphilli
 */
public class ChangeRoles extends ChangeRolesCommon {

    public ChangeRoles(WebDriver driver) throws Exception {

        super(driver);

    }

    public LoginInformation clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new LoginInformation(driver);

    }

    public LoginInformation clickOK() throws Exception {

        super.clickOk();
        return new LoginInformation(driver);
    }
}
