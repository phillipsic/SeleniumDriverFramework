/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author gmaroth
 */
public class SearchAddressCommon extends CommonMenu {

    public SearchAddressCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Search Address";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setCountry(String country) throws Exception {

        new Select(driver.findElement(By.id("home_country"))).selectByVisibleText(country);

    }

    public void setStreetName(String streetname) throws Exception {

        driver.findElement(By.id("streetName")).clear();
        driver.findElement(By.id("streetName")).sendKeys(streetname);

    }

    public void setCity(String city) throws Exception {

        driver.findElement(By.id("home_city")).clear();
        driver.findElement(By.id("home_city")).sendKeys(city);

    }

    public void setZipCode(String zipcode) throws Exception {

        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(zipcode);

    }

    public SearchAddressCommon clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SearchAddressCommon(driver);
    }

    public EnterIdentificationDataCommon clickSelectAddress() throws Exception {
        driver.findElement(By.xpath("//input[@value='Select']")).click();
        return new EnterIdentificationDataCommon(driver);
    }

}
