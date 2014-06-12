package com.comverse.css.TS_CSR;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.csr.rch.*;

@RunWith(Suite.class)
@SuiteClasses({ RCH0005_Recharge.class,
    RCH0010_Non_voucher_recharge.class,
    RCH0020_Non_voucher_recharge_by_credit_card_debit_card.class })
public class CSR_RCH_TS {
}
