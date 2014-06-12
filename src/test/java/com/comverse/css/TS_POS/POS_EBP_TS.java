package com.comverse.css.TS_POS;

import com.comverse.css.pos.ebp.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
   @SuiteClasses({EBP0010_List_Invoices.class,
        EBP0015_View_invoices_details.class,
        EBP0018_View_invoice_balance_details.class,
        EBP0020_View_invoice_image.class,
        EBP0030_List_Payments.class,
        EBP0035_View_payments_distribution.class,
        EBP0040_View_Billed_usage.class,
        EBP0045_View_Billed_usage_detail.class,
        EBP0070_Register_bill_payment.class,
        EBP0080_View_Billed_RC_NRC.class,
        EBP0090_View_Billed_RC_NRC_Detail.class,
        EBP0094_View_Billed_recharges.class,
        EBP0096_View_Billed_MTR.class,
        EBP0100_Register_prepayment.class,
        EBP0110_View_unbilled_RC_NRC.class,
        EBP0130_View_unbilled_usage.class,
        EBP0140_View_unbilled_recharges.class,
        EBP0150_View_unbilled_MTR.class
        })
public class POS_EBP_TS {
}

