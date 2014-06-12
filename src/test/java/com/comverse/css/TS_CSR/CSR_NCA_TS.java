package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.nca.*;

@RunWith(Suite.class)
@SuiteClasses({NCA0010_New_customer_for_Business_and_CSR_Portal.class,
    NCA0010_New_customer_for_Residential_Postpaid_and_CSR_Portal.class,
    NCA0010_New_customer_Residential_Prepaid_With_CUP.class,
    NCA0010_New_customer_with_AB_CSR_Portal.class,
    NCA0010_New_customer_with_SB_CSR_Portal.class,
    NCA0020_Capture_administrative_data.class,
    NCA0030_Capture_billing_information.class,
    NCA0040_Search_and_select_address_in_referential.class})
public class CSR_NCA_TS {
}
