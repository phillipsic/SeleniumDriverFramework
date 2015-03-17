package com.company.css.data.SB;

import com.company.css.data.BAL.BAL_Voice_M2Long_Distance;
import com.company.css.data.BAL.BAL_CORE_BALANCE;
import com.company.css.data.BAL.BAL_MMS_ALL;
import com.company.css.data.BAL.BAL_SMS_ALL;
import com.company.css.data.BAL.BAL_VoiceNightWeekendShared;
import com.company.css.data.BAL.BAL_Voice_M2M;
import com.company.css.data.BAL.BAL_Bonus_Money;
import com.company.css.data.C1Data;
import com.company.css.data.Offer;
import com.company.css.data.PO.PO_ResidentialBasicPrepaid;

public class SB_ResidentialBasicPrepaidBundle extends Offer {

    private C1Data po_ResidentialBasicPrepaid;
    private C1Data bal_CORE_BALANCE;
    private C1Data bal_VoiceNightWeekendShared;
    private C1Data bal_Voice_M2Long_Distance;
    private C1Data bal_Voice_M2M;
    private C1Data bal_SMS_ALL;
    private C1Data bal_MMS_ALL;
    private C1Data bal_Bonus_Money;

    public SB_ResidentialBasicPrepaidBundle() {
        setOfferName("Residential - Basic Prepaid Bundle");
        po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
        bal_CORE_BALANCE = new BAL_CORE_BALANCE();
        bal_VoiceNightWeekendShared = new BAL_VoiceNightWeekendShared();
        bal_Voice_M2Long_Distance = new BAL_Voice_M2Long_Distance();
        bal_Voice_M2M = new BAL_Voice_M2M();
        bal_SMS_ALL = new BAL_SMS_ALL();
        bal_MMS_ALL = new BAL_MMS_ALL();
        bal_Bonus_Money = new BAL_Bonus_Money();
    }

    public C1Data getPO_ResidentialBasicPrepaid() {
        return po_ResidentialBasicPrepaid;
    }

    public C1Data getBAL_CORE_BALANCE() {
        return bal_CORE_BALANCE;
    }

    public C1Data getBAL_VoiceNightWeekendShared() {
        return bal_VoiceNightWeekendShared;
    }
    
    public C1Data getBAL_Voice_M2Long_Distance() {
        return bal_Voice_M2Long_Distance;
    }
    
    public C1Data getBAL_Voice_M2M() {
        return bal_Voice_M2M;
    }
    
    public C1Data getBAL_SMS_ALL() {
        return bal_SMS_ALL;
    }
    
    public C1Data getBAL_MMS_ALL() {
        return bal_MMS_ALL;
    }
    
    public C1Data getBAL_Bonus_Money() {
        return bal_Bonus_Money;
    }
}
