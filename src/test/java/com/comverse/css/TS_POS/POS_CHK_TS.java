package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.chk.CHK0010_Checkout;
import com.comverse.css.pos.chk.CHK0030_Review_order;

@RunWith(Suite.class)
@SuiteClasses({ CHK0010_Checkout.class, CHK0030_Review_order.class })
public class POS_CHK_TS {
}
