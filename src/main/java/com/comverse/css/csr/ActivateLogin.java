/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ActivateLoginCommon;

/**
 * 
 * @author mkumar
 */

public class ActivateLogin extends ActivateLoginCommon {

    public ActivateLogin(WebDriver driver) throws Exception {

        super(driver);

    }

    public UnlockDone clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new UnlockDone(driver);
    }

}
