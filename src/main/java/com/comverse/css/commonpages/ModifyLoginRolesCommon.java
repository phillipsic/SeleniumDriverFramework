/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author gmaroth
 */
public class ModifyLoginRolesCommon extends CommonMenu {

    public ModifyLoginRolesCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Login Roles";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public LoginInformationCommon clickVeiwLoginInformationLink() throws Exception {

        driver.findElement(By.id("smnu_LOGIN")).click();

        return new LoginInformationCommon(driver);
    }
}
