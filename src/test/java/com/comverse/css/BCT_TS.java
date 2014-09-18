package com.comverse.css;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.bct.*;

@RunWith(Suite.class)
@SuiteClasses({ BCT001_PO_Residential_NCA_B2C.class, BCT002_PO_Residential_Recharge_CSR.class, BCT003_PO_Residential_Notification_POS.class, BCT004_PO_Business_Sync_B2B.class,
        BCT005_PO_Residential_Casemanagement_CSR.class, BCT006_Send_outbound_communication_for_a_account_CSR.class, BCT007_Propagation.class, BCT010_WorkPointChecks.class })
public class BCT_TS {
}
