package com.comverse.css.TS_CSR;

import com.comverse.css.csr.sum.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SUM0010_View_and_manage_subscriber.class,
    SUM0020_View_subscribed_primary_offer_details.class,
    SUM0030_View_subscribed_subscriber_bundle_details.class,
    SUM0040_View_subscribed_offer_details.class,
    SUM0050_View_subscriber_status_history.class,
    SUM0060_Modify_subscriber_contact.class,
    SUM0070_Modify_subscriber_attributes.class,
    SUM0080_Migrate_from_prepaid_to_post_paid.class,
    SUM0090_Change_primary_offer_and_supplementary_offers.class,
    SUM0100_Swap_primary_offer_subscriber_bundle.class,
    SUM0110_Update_subscriber_external_id.class,
    SUM0120_View_and_manage_FandF.class,
    SUM0150_Add_subscriber_offers.class,
    SUM0151_Add_unit_pack.class,
    SUM0155_Modify_subscriber_offers.class,
    SUM0160_Remove_subscriber_offer.class,
    SUM0170_Reconfigure_subscriber_selective_offers.class,
    SUM0180_Swap_external_Id.class,
    SUM0200_View_subscribed_RPO.class,
    SUM0210_View_subscribed_RPO_details.class,
    SUM0220_Add_RPO.class,
    SUM0230_Modify_RPO_status.class,
    SUM0240_Reconfigure_award_allocation_counter.class,
    SUM0300_Request_for_coherency_check.class
})
public class CSR_SUM_TS {
}