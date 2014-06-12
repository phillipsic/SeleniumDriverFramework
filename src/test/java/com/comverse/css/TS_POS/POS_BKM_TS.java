package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.bkm.*;

@RunWith(Suite.class)
@SuiteClasses({BKM0010_View_and_manage_basket.class,
    BKM0020_Empty_basket.class,
    BKM0030_Remove_a_basket_item.class,
    BKM0040_Change_primary_offer_of_a_selection.class,
    BKM0050_Save_the_current_basket_automatically.class,
    BKM0060_Manage_an_automatically_saved_basket.class,
    BKM0070_Park_basket.class,
    BKM0080_Resume_a_parked_basket.class,
    BKM0090_Delete_parked_basket.class
})
public class POS_BKM_TS {
}
