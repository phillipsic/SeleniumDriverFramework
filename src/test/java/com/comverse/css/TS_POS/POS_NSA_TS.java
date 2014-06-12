package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.nsa.NSA0010_New_subscriber_for_an_existing_customer;
import com.comverse.css.pos.nsa.NSA0020_Review_existing_account;

@RunWith(Suite.class)
@SuiteClasses({ NSA0010_New_subscriber_for_an_existing_customer.class, NSA0020_Review_existing_account.class })
public class POS_NSA_TS {
}
