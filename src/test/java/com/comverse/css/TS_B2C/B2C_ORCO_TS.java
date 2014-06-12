package com.comverse.css.TS_B2C;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.b2c.orco.*;

@RunWith(Suite.class)
@SuiteClasses({
    ORCO0001_Accept_Terms_and_Conditions.class,
    ORCO0002_Cancel_Order.class,
    ORCO0009_Capture_Billing_Information.class,
    ORCO0011_Capture_Immediate_Payment_Method.class,
    ORCO0012_Capture_Recurring_Payment_Method.class,
    ORCO0013_Capture_Billing_Account_Attributes.class,
    ORCO0014_Capture_Billing_Contact.class,
    ORCO0020_Place_Order.class,
    ORCO0030_Review_Order_Details.class,
    ORCO0100_Authenticate_user.class,
    ORCO0110_Confirm_Customer_Details.class,
    ORCO0111_Modify_Customer_Details.class})
public class B2C_ORCO_TS {
}
