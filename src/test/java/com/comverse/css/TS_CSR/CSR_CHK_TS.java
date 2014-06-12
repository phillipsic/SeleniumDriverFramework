package com.comverse.css.TS_CSR;

import com.comverse.css.csr.chk.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CHK0010_Checkout.class,
    CHK0030_Review_Order.class,
    CHK0040_Pay_now_Devices_and_Accessories_upfront_costs.class
})
public class CSR_CHK_TS {
}
