package com.comverse.css.csr;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InsertInventory {

    public WebDriver driver;

    public InsertInventory(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Insert Inventory";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectInventoryType(String inventoryType) throws Exception {

        new Select(driver.findElement(By.id("inventoryType"))).selectByVisibleText(inventoryType);
        Common.sleepForNumberOfSeconds(10);
    }

    public void setSerialNumber(String serialNumber) throws Exception {

        driver.findElement(By.id("serialNumber")).clear();
        driver.findElement(By.id("serialNumber")).sendKeys(serialNumber);

    }

    public void setPrimaryNumber(String primaryNumber) throws Exception {

        driver.findElement(By.id("primaryNumber")).clear();
        driver.findElement(By.id("primaryNumber")).sendKeys(primaryNumber);

    }

    public void setSecondaryNumber(String secondaryNumber) throws Exception {

        driver.findElement(By.id("secondaryNumber")).clear();
        driver.findElement(By.id("secondaryNumber")).sendKeys(secondaryNumber);

    }

    public void setTertiaryNumber(String tertiaryNumber) throws Exception {

        driver.findElement(By.id("tertiaryNumber")).clear();
        driver.findElement(By.id("tertiaryNumber")).sendKeys(tertiaryNumber);

    }

    public void setServiceNumber(String serviceNumber) throws Exception {

        driver.findElement(By.id("serviceNumber")).clear();
        driver.findElement(By.id("serviceNumber")).sendKeys(serviceNumber);

    }

    public ActionDone clickInsert() throws Exception {

        driver.findElement(By.id("insertbtn")).click();
        
        return new ActionDone(driver);
    }
}
