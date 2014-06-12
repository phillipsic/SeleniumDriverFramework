package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.prs.*;

@RunWith(Suite.class)
@SuiteClasses({ PRS0010_Browse_catalog_to_inform.class, PRS0020_Get_account_pre_requisite_criteria.class,
               PRS0030_Browse_and_select_Primary_Offers_Subscriber_Bundles.class, PRS0040_Browse_and_select_account_bundles.class,
               PRS0050_View_account_bundle_details.class, PRS0060_View_subscriber_bundle_details.class, PRS0070_View_primary_offer_details.class,
               PRS0080_Test_primary_offer_subscriber_bundle_serviceability.class, PRS0090_Add_account_bundle.class,
               PRS0100_Browse_and_select_account_offers.class, PRS0110_Browse_and_select_subscriber_offers.class })
public class POS_PRS_TS {
}
