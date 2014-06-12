package com.comverse.css.TS_POS;

import com.comverse.css.pos.cim.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CIM0010_View_Customer_Information.class,
               CIM0030_Search_List_delivery_addresses.class,
               CIM0040_add_delivery_address.class,
               CIM0050_edit_delivery_address.class,
               CIM0060_remove_delivery_address.class,
        //CIM0070_Set_default_delivery_address.class
})
public class POS_CIM_TS {
}