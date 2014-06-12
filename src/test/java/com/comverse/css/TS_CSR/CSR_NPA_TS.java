package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.npa.NPA0010_Add_Persona_CMP;
import com.comverse.css.csr.npa.NPA0010_Add_Persona_CUP;

@RunWith(Suite.class)
@SuiteClasses({ NPA0010_Add_Persona_CMP.class, NPA0010_Add_Persona_CUP.class })
public class CSR_NPA_TS {
}
