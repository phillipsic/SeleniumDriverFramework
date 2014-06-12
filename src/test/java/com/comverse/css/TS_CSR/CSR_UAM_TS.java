package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.uam.*;

@RunWith(Suite.class)
@SuiteClasses({UAM0010_View_login_information.class,
    UAM0020_Edit_login_information.class,
    UAM0030_Change_password.class,
    UAM0040_Reset_password_of_another_user.class,
    UAM0050_Change_secret_question_and_answer.class,
    UAM0060_Lock_login_manually.class,
    UAM0070_Unlock_login.class,
    UAM0080_Register_login.class,
    UAM0100_Get_forgotten_password.class,
    UAM0110_Change_password_on_first_login.class,
    UAM0120_Deactivate_login.class,
    UAM0130_Reactivate_login.class,
    UAM0140_Force_user_to_change_password_on_first_login.class,
    UAM0200_Add_Login_To_Persona.class
})
public class CSR_UAM_TS {
}