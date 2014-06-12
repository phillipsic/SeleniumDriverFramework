package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.dpm.DPM0010_View_deposits;
import com.comverse.css.csr.dpm.DPM0020_Add_Deposit;

@RunWith(Suite.class)
@SuiteClasses({ DPM0010_View_deposits.class, DPM0020_Add_Deposit.class })
public class CSR_DPM_TS {
}
