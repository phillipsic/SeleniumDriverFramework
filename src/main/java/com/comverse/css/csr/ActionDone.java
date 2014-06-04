package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionDone {
    public WebDriver driver;
    
    public ActionDone(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Action Done";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public InsertInventory clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();

        return new InsertInventory(driver);
    }
}

