package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewBilledUsageCommon extends CommonMenu {

    public ViewBilledUsageCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View Billed Usage";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterFromDate(String fromDate) throws Exception {

        driver.findElement(By.id("fromDate")).clear();
        driver.findElement(By.id("fromDate")).sendKeys(fromDate);

    }

    public ViewBilledUsageCommon clickSearch() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        return new ViewBilledUsageCommon(driver);
    }

    public ViewBilledUsageDetailsCommon clickFirstUsage() throws Exception {

        driver.findElement(By.id("invoiceUsageDetails")).click();
        return new ViewBilledUsageDetailsCommon(driver);
    }

    public ViewInvoiceDetailsCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewInvoiceDetailsCommon(driver);
    }
}
