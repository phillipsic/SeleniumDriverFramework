package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class TestServiceAbilityCommon extends CommonMenu {

    public TestServiceAbilityCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Test Service Ability";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setUnitnumber(String unitNumber) throws Exception {
        driver.findElement(By.id("unitNumber")).clear();
        driver.findElement(By.id("unitNumber")).sendKeys(unitNumber);
    }

    public void setCity(String city) throws Exception {
        driver.findElement(By.id("home_city")).clear();
        driver.findElement(By.id("home_city")).sendKeys(city);
    }

    public void setZipCode(String zipcode) throws Exception {
        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(zipcode);
    }

    public ShoppingCommon clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ShoppingCommon(driver);
    }
}