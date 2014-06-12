package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.epm.EPM0010_Add_employee;
import com.comverse.css.csr.epm.EPM0030_View_employee_contact;
import com.comverse.css.csr.epm.EPM0040_Modify_employee_contact;

@RunWith(Suite.class)
@SuiteClasses({ EPM0010_Add_employee.class, EPM0030_View_employee_contact.class, EPM0040_Modify_employee_contact.class })
public class CSR_EPM_TS {
}
