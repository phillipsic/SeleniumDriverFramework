package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.bam.*;

@RunWith(Suite.class)
@SuiteClasses({BAM0010_View_and_manage_account.class,
    BAM0020_Modify_billing_contact.class,
    BAM0030_Modify_payment_method_information.class,
    BAM0040_Modify_account_attributes.class,
    // BKM0050_Save_the_current_basket_automatically.class,
    // BKM0060_Manage_an_automatically_saved_basket.class,
    BAM0090_Add_account_offers.class,
    BAM0100_Remove_account_offer.class
})
public class POS_BAM_TS {
}
