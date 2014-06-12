package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.idc.*;

@RunWith(Suite.class)
@SuiteClasses({ IDC0001_Browse_Hierarchy.class, IDC0010_Identify_Customer.class, IDC0020_Search_Customer.class, IDC0030_Search_Subscriber.class,
               IDC0040_Automatically_search_customer_from_external_CTI_client.class, IDC0100_Search_persona.class })
public class CSR_IDC_TS {
}
