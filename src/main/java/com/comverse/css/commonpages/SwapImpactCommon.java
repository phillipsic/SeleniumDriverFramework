package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SwapImpactCommon extends CommonMenu {
    static String expectedScreen = "Swap Impact";

    public SwapImpactCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickOK() throws Exception {
        driver.findElement(By.name("ON_OK")).click();
        return new MyBasketCommon(driver);
    }
    public ConfigureBalanceCommon clickOKExpectingConfigureBalance()throws Exception {
    	driver.findElement(By.name("ON_OK")).click();
    	return new ConfigureBalanceCommon(driver);
    }
}
