package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewInvoiceDetailsCommon extends CommonMenu {

    public ViewInvoiceDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View invoice details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public InvoiceImageInTextCommon clickAsciiImage() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//img[@title='Simple format - Ascii']");
        return new InvoiceImageInTextCommon(tool, test, user);
    }

    public ViewInvoiceBalanceDetailsCommon clickBalanceName() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath(".//a[contains(text(),'Balances')]//../../../../../../following::tbody[2]/tr[1]/td/div/a");
        return new ViewInvoiceBalanceDetailsCommon(tool, test, user);
    }

    public BilledAdjustmentsCommon clickBilledAdjustments() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_VIEW_ADJUSTMENTS");
        return new BilledAdjustmentsCommon(tool, test, user);
    }

    public ViewPaymentDistributionsCommon clickPaymentDistribution() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_VIEW_PAYMENT_DISTRIBUTIONS");
        return new ViewPaymentDistributionsCommon(tool, test, user);
    }

    public ViewBilledRCNRCTermsCommon clickBilledRCNRC() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_VIEW_RC_NRC");
        return new ViewBilledRCNRCTermsCommon(tool, test, user);
    }

    public ViewBilledRechargesCommon clickBilledRecharges() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_VIEW_INVOICE_RECHARGES");
        return new ViewBilledRechargesCommon(tool, test, user);
    }

    public ViewBilledUsageCommon clickBilledUsages() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_VIEW_USAGES");
        return new ViewBilledUsageCommon(tool, test, user);
    }

    public ViewBilledMTRCommon clickBilledMTR() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_VIEW_INVOICE_MTR");
        return new ViewBilledMTRCommon(tool, test, user);
    }

    public ViewInvoicesCommon clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Back']");
        return new ViewInvoicesCommon(tool, test, user);
    }
}
