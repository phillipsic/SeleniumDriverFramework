package com.comverse.css.TS_B2B;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2b.bkm.BKM0070_Park_basket;
import com.comverse.css.b2b.bkm.BKM0080_Resume_a_parked_basket;
import com.comverse.css.b2b.bkm.BKM0090_Delete_parked_basket;

@RunWith(Suite.class)
@SuiteClasses({ BKM0070_Park_basket.class, BKM0080_Resume_a_parked_basket.class, BKM0090_Delete_parked_basket.class

})
public class B2B_BKM_TS {
}
