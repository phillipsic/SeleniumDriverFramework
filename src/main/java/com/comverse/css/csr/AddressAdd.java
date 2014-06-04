package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressAdd {
    public WebDriver driver;
    
    public AddressAdd(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Address Add";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setStreetName(String streetname) throws Exception {

        driver.findElement(By.id("add_streetName")).clear();
        driver.findElement(By.id("add_streetName")).sendKeys(streetname);

    }

    public void setCity(String city) throws Exception {

        driver.findElement(By.id("add_city")).clear();
        driver.findElement(By.id("add_city")).sendKeys(city);

    }

    public void setZipCode(String zipcode) throws Exception {

        driver.findElement(By.id("add_postalCode")).clear();
        driver.findElement(By.id("add_postalCode")).sendKeys(zipcode);

    }


    public void selectCountry(String country) throws Exception {

       new Select(driver.findElement(By.id("add_countryCode"))).selectByVisibleText(country);

    }

    public AddressAdministration clickOK() throws Exception {

        driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new AddressAdministration(driver);
    }
}

