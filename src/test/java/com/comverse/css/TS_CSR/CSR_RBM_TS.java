package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.rbm.*;

@RunWith(Suite.class)
@SuiteClasses({ RBM0010_Configure_spending_credit_limits.class,
    RBM0020_Configure_shadow_balances.class,
    RBM0030_Display_balances.class,
    RBM0040_Display_balance_details.class,
	RBM0050_Reconfigure_spending_credit_limit.class,
	RBM0060_Reconfigure_shadow_balance.class })
public class CSR_RBM_TS {
}
