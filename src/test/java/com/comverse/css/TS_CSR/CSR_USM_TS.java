package com.comverse.css.TS_CSR;

import com.comverse.css.csr.usm.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({USM0010_Login.class,
    USM0020_Logout.class,
    USM0040_Display_home_page_for_a_telco.class
})
public class CSR_USM_TS {
}
