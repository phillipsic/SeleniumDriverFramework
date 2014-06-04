/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.CommonMenu;

/**
 * 
 * @author gmaroth
 */
public class ModifyLoginRoles extends CommonMenu {

    public ModifyLoginRoles(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Login Roles";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public LoginInformation clickVeiwLoginInformationLink() throws Exception {

        driver.findElement(By.id("smnu_LOGIN")).click();

        return new LoginInformation(driver);
    }
}
