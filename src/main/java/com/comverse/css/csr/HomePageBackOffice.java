/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBackOffice {

    public WebDriver driver;

    public HomePageBackOffice(WebDriver driver) {

        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Welcome to Your Workspace";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public InventoryAdministration clickBackOffice() throws Exception {

        driver.findElement(By.id("mnu_BACK_OFFICE")).click();

        return new InventoryAdministration(driver);

    }

    
}
