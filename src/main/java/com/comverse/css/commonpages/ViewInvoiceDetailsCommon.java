package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewInvoiceDetailsCommon extends CommonMenu {

    public ViewInvoiceDetailsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View invoice details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public InvoiceImageInTextCommon clickAsciiImage() throws Exception {
        driver.findElement(By.xpath("//img[@title='Simple format - Ascii']")).click();
        return new InvoiceImageInTextCommon(driver);
    }

    public ViewInvoiceBalanceDetailsCommon clickBalanceName() throws Exception {
        driver.findElement(By.xpath(".//a[contains(text(),'Balances')]//../../../../../../following::tbody[2]/tr[1]/td/div/a")).click();
        return new ViewInvoiceBalanceDetailsCommon(driver);
    }

    public BilledAdjustmentsCommon clickBilledAdjustments() throws Exception {
        driver.findElement(By.id("youcan_VIEW_ADJUSTMENTS")).click();
        return new BilledAdjustmentsCommon(driver);
    }

    public ViewPaymentDistributionsCommon clickPaymentDistribution() throws Exception {
        driver.findElement(By.id("youcan_VIEW_PAYMENT_DISTRIBUTIONS")).click();
        return new ViewPaymentDistributionsCommon(driver);
    }

    public ViewBilledRCNRCTermsCommon clickBilledRCNRC() throws Exception {
        driver.findElement(By.id("youcan_VIEW_RC_NRC")).click();
        return new ViewBilledRCNRCTermsCommon(driver);
    }

    public ViewBilledRechargesCommon clickBilledRecharges() throws Exception {
        driver.findElement(By.id("youcan_VIEW_INVOICE_RECHARGES")).click();
        return new ViewBilledRechargesCommon(driver);
    }

    public ViewBilledUsageCommon clickBilledUsages() throws Exception {
        driver.findElement(By.id("youcan_VIEW_USAGES")).click();
        return new ViewBilledUsageCommon(driver);
    }

    public ViewBilledMTRCommon clickBilledMTR() throws Exception {
        driver.findElement(By.id("youcan_VIEW_INVOICE_MTR")).click();
        return new ViewBilledMTRCommon(driver);
    }

    public ViewInvoicesCommon clickBack() throws Exception {
        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewInvoicesCommon(driver);
    }
}
