package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddLevelContactInformationCommon {
    static String expectedScreen = "Add Level - Contact Information";
    public WebDriver driver;

    public AddLevelContactInformationCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLevelState(String levelState) throws Exception {

        new Select(driver.findElement(By.id("home_state"))).selectByVisibleText(levelState);
    }

    public void setLevelZipCode(String zipCode) throws Exception {

        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(zipCode);
    }

    public void setLevelName(String levelName) throws Exception {

        driver.findElement(By.id("company_name")).clear();
        driver.findElement(By.id("company_name")).sendKeys(levelName);
    }

    public AddLevelConfirmationCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AddLevelConfirmationCommon(driver);
    }
}
