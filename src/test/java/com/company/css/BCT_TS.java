package com.company.css;

import com.company.css.bct.BCT010_WorkPointChecks;
import com.company.css.bct.BCT005_PO_Residential_Casemanagement_CSR;
import com.company.css.bct.BCT001_PO_Residential_NCA_B2C;
import com.company.css.bct.BCT006_Send_outbound_communication_for_a_account_CSR;
import com.company.css.bct.BCT004_PO_Business_Sync_B2B;
import com.company.css.bct.BCT007_Propagation;
import com.company.css.bct.BCT003_PO_Residential_Notification_POS;
import com.company.css.bct.BCT002_PO_Residential_Recharge_CSR;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ BCT001_PO_Residential_NCA_B2C.class, BCT002_PO_Residential_Recharge_CSR.class, BCT003_PO_Residential_Notification_POS.class, BCT004_PO_Business_Sync_B2B.class,
        BCT005_PO_Residential_Casemanagement_CSR.class, BCT006_Send_outbound_communication_for_a_account_CSR.class, BCT007_Propagation.class, BCT010_WorkPointChecks.class })
public class BCT_TS {
}
