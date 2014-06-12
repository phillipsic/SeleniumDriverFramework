package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.pem.*;

@RunWith(Suite.class)
@SuiteClasses({ PEM0010_View_persona_summary.class, PEM0020_Modify_existing_person_details.class, PEM0030_Modify_person_legal_address.class,
               PEM0060_Modify_persona_role.class, PEM0070_Deactivate_persona.class, PEM0100_Change_Owner.class, PEM0150_Search_Person.class,
               PEM0200_Dissociate_persona_from_account.class, PEM0300_Associate_persona_to_subscription.class,
               PEM0310_Dissociate_persona_from_subscription.class, PEM0430_Merge_persons.class, PEM0500_List_personas.class })
public class CSR_PEM_TS {
}
