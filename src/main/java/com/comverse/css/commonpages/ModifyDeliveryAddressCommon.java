/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ModifyDeliveryAddressCommon extends CommonMenu {

    public ModifyDeliveryAddressCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Delivery Address";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectCountry(String country) {

        new Select(driver.findElement(By.id("country"))).selectByVisibleText(country);

    }

    public void selectState(String state) {

        new Select(driver.findElement(By.id("state_region"))).selectByVisibleText(state);

    }

    public void setAddressLine1(String addressline1) {

        driver.findElement(By.id("address_line_1")).clear();
        driver.findElement(By.id("address_line_1")).sendKeys(addressline1);

    }

    public void setAddressLine2(String addressline2) {

        driver.findElement(By.id("address_line_2")).clear();
        driver.findElement(By.id("address_line_2")).sendKeys(addressline2);

    }

    public void setAddressLine3(String addressline3) {

        driver.findElement(By.id("address_line_3")).clear();
        driver.findElement(By.id("address_line_3")).sendKeys(addressline3);

    }

    public void setAddressLine4(String addressline4) {

        driver.findElement(By.id("address_line_4")).clear();
        driver.findElement(By.id("address_line_4")).sendKeys(addressline4);

    }

    public void setZipCode(String zipcode) {

        driver.findElement(By.id("zip_code")).clear();
        driver.findElement(By.id("zip_code")).sendKeys(zipcode);

    }

    public void setCity(String city) {

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);

    }

    public ModifyDeliveryAddressConfirmationCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ModifyDeliveryAddressConfirmationCommon(driver);
    }
}
