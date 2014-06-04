package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdjustBalanceRequestResultCommon extends CommonMenu {
    static String expectedScreen = "Adjust balance - request result";

    public AdjustBalanceRequestResultCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewBalanceCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewBalanceCommon(driver);
    }
}
