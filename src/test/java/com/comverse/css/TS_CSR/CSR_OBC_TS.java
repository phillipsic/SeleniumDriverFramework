package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.obc.OBC0_Generate_outbound_communication_and_send;
import com.comverse.css.csr.obc.OBC1_Send_outbound_communication_during_new_case_creation;

@RunWith(Suite.class)
@SuiteClasses({ OBC0_Generate_outbound_communication_and_send.class,
    OBC1_Send_outbound_communication_during_new_case_creation.class})
public class CSR_OBC_TS {
}
