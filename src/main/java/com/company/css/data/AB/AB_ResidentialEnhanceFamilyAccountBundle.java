package com.company.css.data.AB;

import com.company.css.data.C1Data;
import com.company.css.data.Offer;
import com.company.css.data.BAL.BAL_GPRS_WAP_INTERNET;
import com.company.css.data.BAL.BAL_VoiceAnytimeShared;
import com.company.css.data.BAL.BAL_VoiceNightWeekendShared;
import com.company.css.data.SB.SB_ResidentialBasicPrepaidBundle;
import com.company.css.data.SB.SB_ResidentialUltraPostpaidBundle;

public class AB_ResidentialEnhanceFamilyAccountBundle extends Offer {
    private C1Data sb_ResidentialBasicPrepaidBundle;
    private C1Data sb_ResidentialUltraPostpaidBundle;
    private C1Data bal_GPRS_WAP_INTERNET;
    private C1Data bal_VoiceNightWeekendShared;
    private C1Data bal_VoiceAnytimeShared;

    public AB_ResidentialEnhanceFamilyAccountBundle() {
        setOfferName("Residential Enhanced Family Account Bundle");
        sb_ResidentialBasicPrepaidBundle = new SB_ResidentialBasicPrepaidBundle();
        sb_ResidentialUltraPostpaidBundle = new SB_ResidentialUltraPostpaidBundle();
        bal_GPRS_WAP_INTERNET = new BAL_GPRS_WAP_INTERNET();
        bal_VoiceNightWeekendShared = new BAL_VoiceNightWeekendShared();
        bal_VoiceAnytimeShared = new BAL_VoiceAnytimeShared();
    }

    public C1Data getSB_ResidentialBasicPrepaidBundle() {
        return sb_ResidentialBasicPrepaidBundle;
    }

    public C1Data getSB_ResidentialUltraPostpaidBundle() {
        return sb_ResidentialUltraPostpaidBundle;
    }

    @Override
	public C1Data getBAL_GPRS_WAP_INTERNET() {
        return bal_GPRS_WAP_INTERNET;
    }

    public C1Data getBAL_VoiceNightWeekendShared() {
        return bal_VoiceNightWeekendShared;
    }

    public C1Data getBAL_VoiceAnytimeShared() {
        return bal_VoiceAnytimeShared;
    }
}
