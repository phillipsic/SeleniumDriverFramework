package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.chk.CHK0010_Checkout;
import com.comverse.css.csr.chk.CHK0030_Review_Order;
import com.comverse.css.csr.chk.CHK0040_Pay_now_Devices_and_Accessories_upfront_costs;

@RunWith(Suite.class)
@SuiteClasses({CHK0010_Checkout.class,
    CHK0030_Review_Order.class,
    CHK0040_Pay_now_Devices_and_Accessories_upfront_costs.class
})
public class CSR_CHK_TS {
}
