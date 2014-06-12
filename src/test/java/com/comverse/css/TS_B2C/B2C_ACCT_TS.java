package com.comverse.css.TS_B2C;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2c.acct.*;

@RunWith(Suite.class)
@SuiteClasses({ACCT0501_Recharge_Credit.class,
    ACCT0412AB_Subscribe_New_Services_AB_SB_PO.class,
    ACCT0413AB_Remove_Service_AB_SB_PO.class,
    ACCT0421_Modify_Service.class,
    ACCT0550ConfigureSubscriberBalance.class,
    ACCT0550Contract_Set_spending_limit_on_monetary_shadow_balance.class})
public class B2C_ACCT_TS {
}
