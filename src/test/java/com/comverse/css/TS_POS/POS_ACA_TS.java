package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.aca.ACA0010_View_usage_history;
import com.comverse.css.pos.aca.ACA0020_View_MTR_history;
import com.comverse.css.pos.aca.ACA0030_View_RC_history;
import com.comverse.css.pos.aca.ACA0040_View_NRC_history;
import com.comverse.css.pos.aca.ACA0050_View_subscriber_combined_history;

@RunWith(Suite.class)
@SuiteClasses({ACA0010_View_usage_history.class,
    ACA0020_View_MTR_history.class,
    ACA0030_View_RC_history.class,
    ACA0040_View_NRC_history.class,
    ACA0050_View_subscriber_combined_history.class})
public class POS_ACA_TS {
}
