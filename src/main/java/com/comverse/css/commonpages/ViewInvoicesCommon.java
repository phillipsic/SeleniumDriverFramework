package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewInvoicesCommon extends CommonMenu {

    public ViewInvoicesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View invoices";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public ViewTransactionHistoryCommon clickTransactionHistory() throws Exception {

        tool.driver.findElement(By.id("mnu_HISTORIES")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickUnbilledTransacations() throws Exception {

        tool.driver.findElement(By.id("smnu_UNBILLED_TRANSACTIONS")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UnbilledTransactionCommon(tool, test, user);
    }

    public ViewPaymentsCommon clickPayments() throws Exception {

        tool.driver.findElement(By.id("smnu_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewPaymentsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickLastInvoice() throws Exception {

        tool.driver.findElement(By.xpath("//table[@id='listInvoices']/tbody/tr[2]/td/a")).click();
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickInvoiceNumber(String billrefnumber) throws Exception {

        tool.driver.findElement(By.linkText(billrefnumber)).click();
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }

    public RegisterBillPaymentCommon clickPayLastInvoice() throws Exception {

        tool.driver.findElement(By.linkText("Pay invoice")).click();
        return new RegisterBillPaymentCommon(tool, test, user);
    }

}
