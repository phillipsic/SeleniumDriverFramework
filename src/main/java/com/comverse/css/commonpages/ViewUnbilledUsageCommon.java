package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewUnbilledUsageCommon extends CommonMenu {

    public ViewUnbilledUsageCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View unbilled usage";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterToDate(String toDate) throws Exception {

        driver.findElement(By.id("toDate")).clear();
        driver.findElement(By.id("toDate")).sendKeys(toDate);

    }

    public void enterFromDate(String fromDate) throws Exception {

        driver.findElement(By.id("fromDate")).clear();
        driver.findElement(By.id("fromDate")).sendKeys(fromDate);

    }

    public ViewUnbilledUsageCommon clickSearch() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        return new ViewUnbilledUsageCommon(driver);
    }

    public ViewUnbilledUsageDetailsCommon clickFirstUsage() throws Exception {

        driver.findElement(By.id("usageDetails")).click();
        return new ViewUnbilledUsageDetailsCommon(driver);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new UnbilledTransactionCommon(driver);
    }
}
