package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewPaymentsCommon extends CommonMenu {

    public ViewPaymentsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View Payments";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterFromDate(String fromDate) throws Exception {

        driver.findElement(By.id("startDate")).clear();
        driver.findElement(By.id("startDate")).sendKeys(fromDate);

    }

    public ViewPaymentsCommon clickSearch() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        return new ViewPaymentsCommon(driver);
    }
}
