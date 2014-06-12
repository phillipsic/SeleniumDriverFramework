package com.comverse.css.TS_B2B;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2b.cim.*;

@RunWith(Suite.class)
@SuiteClasses({
    CIM0030_Search_List_delivery_addresses.class,
    CIM0040_add_delivery_address.class,
    CIM0050_edit_delivery_address.class,
    CIM0060_remove_delivery_address.class,
    CIM0070_Set_default_delivery_address.class
})
public class B2B_CIM_TS {
}