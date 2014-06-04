package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdjustBalanceReviewCommon extends CommonMenu {
    static String expectedScreen = "Adjust balance - Review";

    public AdjustBalanceReviewCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public AdjustBalanceRequestResultCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new AdjustBalanceRequestResultCommon(driver);
    }
}
