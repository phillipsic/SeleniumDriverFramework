package com.comverse.css.TS_B2C;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2c.orma.*;

@RunWith(Suite.class)
@SuiteClasses({
    ORMA0001_List_All_Orders_ResidentialUser.class,
    ORMA0031_View_order_details.class})
public class B2C_ORMA_TS {
}
