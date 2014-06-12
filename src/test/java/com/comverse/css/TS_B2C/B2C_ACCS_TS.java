package com.comverse.css.TS_B2C;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2c.accs.*;

@RunWith(Suite.class)
@SuiteClasses({ ACCS0000_CreateExistingAccount.class, ACCS0010_Login.class, ACCS0010_Login_with_CUP.class, ACCS0020_Logout.class,
               ACCS0100_Lock_Login_after_login_failed.class, ACCS0103_Lock_Login_Manually.class, ACCS0500_Sign_me_up_for_Customer.class })
public class B2C_ACCS_TS {
}
