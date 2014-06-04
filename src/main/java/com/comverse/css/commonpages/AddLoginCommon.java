package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddLoginCommon extends CommonMenu {
    static String expectedScreen = "Add Login";

    public AddLoginCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public PersonManagementCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new PersonManagementCommon(driver);
    }

    public void setLogin(String value) throws Exception {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(value);
    }

    public void setPassword(String value) throws Exception {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(value);
    }

    public void setConfirmPassword(String value) throws Exception {
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys(value);
    }
}
