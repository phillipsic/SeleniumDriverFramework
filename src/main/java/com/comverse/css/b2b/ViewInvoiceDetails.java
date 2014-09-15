package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewInvoiceDetailsCommon;

public class ViewInvoiceDetails extends ViewInvoiceDetailsCommon {

    public ViewInvoiceDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewBilledMTR clickBilledMTR() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBilledMTR();
        return new ViewBilledMTR(tool, test, user);
    }

    @Override
    public ViewBilledRecharges clickBilledRecharges() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBilledRecharges();
        return new ViewBilledRecharges(tool, test, user);
    }

    @Override
    public ViewBilledRCNRCTerms clickBilledRCNRC() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBilledRCNRC();
        return new ViewBilledRCNRCTerms(tool, test, user);
    }

    @Override
    public ViewInvoices clickBack() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBack();
        return new ViewInvoices(tool, test, user);
    }

    @Override
    public ViewBilledUsage clickBilledUsages() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBilledUsages();
        return new ViewBilledUsage(tool, test, user);
    }

    @Override
    public ViewPaymentDistributions clickPaymentDistribution() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickPaymentDistribution();
        return new ViewPaymentDistributions(tool, test, user);
    }

    @Override
    public InvoiceImageInText clickAsciiImage() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickAsciiImage();
        return new InvoiceImageInText(tool, test, user);
    }

    @Override
    public ViewInvoiceBalanceDetails clickBalanceName() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBalanceName();
        return new ViewInvoiceBalanceDetails(tool, test, user);
    }
}
