package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressAddCommon {
    public WebDriver driver;
    static String expectedScreen = "Address Add";

    public AddressAddCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setStreetName(String streetname) throws Exception {

        driver.findElement(By.id("streetName")).clear();
        driver.findElement(By.id("streetName")).sendKeys(streetname);

    }

    public void setCity(String city) throws Exception {

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);

    }

    public void setZipCode(String zipcode) throws Exception {

        driver.findElement(By.id("postalCode")).clear();
        driver.findElement(By.id("postalCode")).sendKeys(zipcode);

    }

    public void selectCountry(String country) throws Exception {

        new Select(driver.findElement(By.id("countryCode"))).selectByVisibleText(country);

    }

    public AddressAdministrationCommon clickOK() throws Exception {

        driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new AddressAdministrationCommon(driver);
    }
}
