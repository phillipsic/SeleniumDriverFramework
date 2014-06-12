package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RegisterBillPaymentCommon;

public class RegisterBillPayment extends RegisterBillPaymentCommon {

    public RegisterBillPayment(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public RegisterBillPayment clickContinue() throws Exception {

        super.clickContinue();
        return new RegisterBillPayment(tool, test, user);
    }

    @Override
    public RegisterBillPayment clickConfirm() throws Exception {

        super.clickConfirm();
        return new RegisterBillPayment(tool, test, user);
    }

    @Override
    public ViewInvoices clickBackToInvoices() throws Exception {

        super.clickBackToInvoices();
        return new ViewInvoices(tool, test, user);
    }
}
