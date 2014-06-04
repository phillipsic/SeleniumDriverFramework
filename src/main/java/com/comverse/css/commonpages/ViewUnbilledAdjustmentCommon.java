package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewUnbilledAdjustmentCommon extends CommonMenu {

    public ViewUnbilledAdjustmentCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View Unbilled Adjustments";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public AdjustmentDetailsCommon clickFirstAdjustment() throws Exception {

        driver.findElement(By.xpath("//fieldset/div/table/tbody[2]/tr/td/div/a")).click();
        return new AdjustmentDetailsCommon(driver);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new UnbilledTransactionCommon(driver);
    }
}
