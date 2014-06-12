package com.comverse.css.TS_B2C;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2c.nca.NCA0010_PO_Residential_Basic_Prepaid;
import com.comverse.css.b2c.nca.NCA0010_PO_Residential_Ultra_Postpaid;

@RunWith(Suite.class)
@SuiteClasses({ NCA0010_PO_Residential_Basic_Prepaid.class, NCA0010_PO_Residential_Ultra_Postpaid.class })
public class B2C_NCA_TS {
}
