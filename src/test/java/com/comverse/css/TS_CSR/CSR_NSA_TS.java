package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.nsa.NSA0010_New_subscriber_for_an_existing_customer;
import com.comverse.css.csr.nsa.NSA0020_Review_existing_account;
import com.comverse.css.csr.nsa.NSA0025_Update_administrative_data;
import com.comverse.css.csr.nsa.NSA0030_Capture_billing_information;

@RunWith(Suite.class)
@SuiteClasses({NSA0010_New_subscriber_for_an_existing_customer.class,
    NSA0020_Review_existing_account.class,
    NSA0025_Update_administrative_data.class,
    NSA0030_Capture_billing_information.class})
public class CSR_NSA_TS {
}
