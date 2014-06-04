package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewBilledUsageDetailsCommon extends CommonMenu {

    public ViewBilledUsageDetailsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View Billed Usage Details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewBilledUsageCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewBilledUsageCommon(driver);
    }
}
