package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.clm.*;

@RunWith(Suite.class)
@SuiteClasses({ CLM0010_Suspend_Subscriber.class, CLM0020_Resume_Subscriber.class, CLM0030_Fraud_lock_a_Subscriber.class,
               CLM0040_Unlock_fraud_locked_subscriber.class, CLM0050_Disconnect_subscriber.class })
public class POS_CLM_TS {
}