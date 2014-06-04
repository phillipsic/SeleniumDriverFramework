package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReconfigureBalanceConfirmCommon extends CommonMenu {

    static String expectedScreen = "Configure balance - Confirm";

    public ReconfigureBalanceConfirmCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!currentScreen.equals(expectedScreen)) {
            throw new IllegalStateException("Expected: " + expectedScreen + " but got: " + currentScreen);
        }
    }

    public ViewBalanceCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewBalanceCommon(driver);
    }

}
