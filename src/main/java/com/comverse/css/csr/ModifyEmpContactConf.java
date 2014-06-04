/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyEmpContactConfCommon;

/**
 * 
 * @author mkumar
 */
public class ModifyEmpContactConf extends ModifyEmpContactConfCommon {

    public ModifyEmpContactConf(WebDriver driver) throws Exception {
        super(driver);

    }

    public void clickOk() {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

}
