package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.idc.IDC0001_Browse_Hierarchy;
import com.comverse.css.pos.idc.IDC0010_Identify_Customer;
import com.comverse.css.pos.idc.IDC0020_Search_Customer;
import com.comverse.css.pos.idc.IDC0030_Search_Subscriber;

@RunWith(Suite.class)
@SuiteClasses({ IDC0001_Browse_Hierarchy.class, IDC0010_Identify_Customer.class, IDC0020_Search_Customer.class, IDC0030_Search_Subscriber.class })
public class POS_IDC_TS {
}
