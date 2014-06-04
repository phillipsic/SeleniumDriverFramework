/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBackOfficeCommon {

    public WebDriver driver;

    public HomePageBackOfficeCommon(WebDriver driver) {

        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Home Page - Back Office, Inventory and Order Management";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddressAdministrationCommon clickAddressAdministration() throws Exception {

        driver.findElement(By.id("smnu_ADDRESS_ADMINISTRATION")).click();

        return new AddressAdministrationCommon(driver);

    }

    public TokensfoundCommon clickTokenAdministration() throws Exception {

        driver.findElement(By.id("smnu_TOKEN_ADMINISTRATION")).click();

        return new TokensfoundCommon(driver);

    }

    public OutboundCommunicationTemplateCommon clickTemplateAdministration() throws Exception {

        driver.findElement(By.id("smnu_TEMPLATE_ADMINISTRATION")).click();

        return new OutboundCommunicationTemplateCommon(driver);

    }
}
