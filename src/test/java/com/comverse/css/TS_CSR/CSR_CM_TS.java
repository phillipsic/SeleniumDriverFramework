package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.cm.*;

@RunWith(Suite.class)
@SuiteClasses({CM0001_List_Cases_for_Channel_and_CSR_Portal.class,
    CM0010_Create_case_without_Edialog_for_Channel_CSR_portal.class,
    CM0020_View_existing_cases_and_details_for_Channel_and_CSR_Portal.class,
    CM0200_Update_case.class,
    CM0230_Cancel_case.class,
    CM0220_Re_open_case.class,
    CM0100_Attach_file_to_a_case.class
})
public class CSR_CM_TS {
}
