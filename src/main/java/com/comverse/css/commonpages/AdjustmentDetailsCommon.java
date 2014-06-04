package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdjustmentDetailsCommon extends CommonMenu {
    static String expectedScreen = "Adjustment details";

    public AdjustmentDetailsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public ViewUnbilledAdjustmentCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewUnbilledAdjustmentCommon(driver);
    }
}
