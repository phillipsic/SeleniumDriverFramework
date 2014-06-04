package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressAdministration {
    public WebDriver driver;
    
    public AddressAdministration(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Address Administration";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddressAdd clickAdd() throws Exception {

        driver.findElement(By.xpath("//input[@value='Add']")).click();

        return new AddressAdd(driver);
    }
}

