package com.comverse.css.TS_B2B;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2b.cm.CM0005_List_Cases;
import com.comverse.css.b2b.cm.CM0015_Create_case;
import com.comverse.css.b2b.cm.CM0025_View_existing_cases_and_details;

@RunWith(Suite.class)
@SuiteClasses({ CM0005_List_Cases.class, CM0015_Create_case.class, CM0025_View_existing_cases_and_details.class })
public class B2B_CM_TS {
}