package com.comverse.css.TS_CSR;

import com.comverse.css.csr.bam.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BAM0010_View_and_manage_account.class,
    BAM0020_Modify_billing_contact.class,
    BAM0030_Modify_payment_method_information.class,
    BAM0040_Modify_account_attributes.class,
    BAM0090_Add_account_offers.class,
    BAM0100_Remove_account_offer.class,
    BAM0110_Reconfigure_account_selective_offers.class
})
public class CSR_BAM_TS {
}
