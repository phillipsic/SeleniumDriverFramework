/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class ModifyLoginPasswordCommon extends CommonMenu {

    public ModifyLoginPasswordCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Login Password";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
       
    }

    public String getNewPassword() throws Exception {

        String password = driver.findElement(By.xpath("//div[@id='mainContents']/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }
}
