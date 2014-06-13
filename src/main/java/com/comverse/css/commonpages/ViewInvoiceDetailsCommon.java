package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewInvoiceDetailsCommon extends CommonMenu {

    public ViewInvoiceDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View invoice details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public InvoiceImageInTextCommon clickAsciiImage() throws Exception {
        tool.clickUsingXPath(tool, "//img[@title='Simple format - Ascii']");
        return new InvoiceImageInTextCommon(tool, test, user);
    }

    public ViewInvoiceBalanceDetailsCommon clickBalanceName() throws Exception {
        tool.clickUsingXPath(tool, ".//a[contains(text(),'Balances')]//../../../../../../following::tbody[2]/tr[1]/td/div/a");
        return new ViewInvoiceBalanceDetailsCommon(tool, test, user);
    }

    public BilledAdjustmentsCommon clickBilledAdjustments() throws Exception {
        tool.driver.findElement(By.id("youcan_VIEW_ADJUSTMENTS")).click();
        return new BilledAdjustmentsCommon(tool, test, user);
    }

    public ViewPaymentDistributionsCommon clickPaymentDistribution() throws Exception {
        tool.driver.findElement(By.id("youcan_VIEW_PAYMENT_DISTRIBUTIONS")).click();
        return new ViewPaymentDistributionsCommon(tool, test, user);
    }

    public ViewBilledRCNRCTermsCommon clickBilledRCNRC() throws Exception {
        tool.driver.findElement(By.id("youcan_VIEW_RC_NRC")).click();
        return new ViewBilledRCNRCTermsCommon(tool, test, user);
    }

    public ViewBilledRechargesCommon clickBilledRecharges() throws Exception {
        tool.driver.findElement(By.id("youcan_VIEW_INVOICE_RECHARGES")).click();
        return new ViewBilledRechargesCommon(tool, test, user);
    }

    public ViewBilledUsageCommon clickBilledUsages() throws Exception {
        tool.driver.findElement(By.id("youcan_VIEW_USAGES")).click();
        return new ViewBilledUsageCommon(tool, test, user);
    }

    public ViewBilledMTRCommon clickBilledMTR() throws Exception {
        tool.driver.findElement(By.id("youcan_VIEW_INVOICE_MTR")).click();
        return new ViewBilledMTRCommon(tool, test, user);
    }

    public ViewInvoicesCommon clickBack() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new ViewInvoicesCommon(tool, test, user);
    }
}
