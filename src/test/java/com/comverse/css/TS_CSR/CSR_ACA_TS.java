package com.comverse.css.TS_CSR;

import com.comverse.css.csr.aca.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ACA0010_View_usage_history.class,
        ACA0020_View_MTR_history.class,
        ACA0030_View_RC_history.class,
        ACA0040_View_NRC_history.class,
        ACA0050_View_subscriber_combined_history.class
      })
public class CSR_ACA_TS {
}
