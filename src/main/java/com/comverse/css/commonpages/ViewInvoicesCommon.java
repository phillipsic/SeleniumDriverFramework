package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class ViewInvoicesCommon extends CommonMenu {

    public ViewInvoicesCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View invoices";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public ViewTransactionHistoryCommon clickTransactionHistory() throws Exception {

        driver.findElement(By.id("mnu_HISTORIES")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(driver);
    }

    public UnbilledTransactionCommon clickUnbilledTransacations() throws Exception {

        driver.findElement(By.id("smnu_UNBILLED_TRANSACTIONS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new UnbilledTransactionCommon(driver);
    }

    public ViewPaymentsCommon clickPayments() throws Exception {

        driver.findElement(By.id("smnu_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewPaymentsCommon(driver);
    }

    public ViewInvoiceDetailsCommon clickLastInvoice() throws Exception {

        driver.findElement(By.xpath("//table[@id='listInvoices']/tbody/tr[2]/td/a")).click();
        return new ViewInvoiceDetailsCommon(driver);
    }

    public ViewInvoiceDetailsCommon clickInvoiceNumber(String billrefnumber) throws Exception {

        driver.findElement(By.linkText(billrefnumber)).click();
        return new ViewInvoiceDetailsCommon(driver);
    }

    public RegisterBillPaymentCommon clickPayLastInvoice() throws Exception {

        driver.findElement(By.linkText("Pay invoice")).click();
        return new RegisterBillPaymentCommon(driver);
    }

}
