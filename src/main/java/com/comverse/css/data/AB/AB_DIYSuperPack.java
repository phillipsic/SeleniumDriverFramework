package com.comverse.css.data.AB;

import com.comverse.css.data.C1Data;
import com.comverse.css.data.Offer;
import com.comverse.css.data.BAL.BAL_GPRS_WAP_INTERNET;
import com.comverse.css.data.BAL.BAL_VoiceAnytimeShared;
import com.comverse.css.data.BAL.BAL_VoiceNightWeekendShared;
import com.comverse.css.data.SB.SB_ResidentialBasicPrepaidBundle;
import com.comverse.css.data.SB.SB_ResidentialUltraPostpaidBundle;

public class AB_DIYSuperPack extends Offer {
    private C1Data sb_ResidentialBasicPrepaidBundle;
    private C1Data sb_ResidentialUltraPostpaidBundle;
    private C1Data bal_GPRS_WAP_INTERNET;
    private C1Data bal_VoiceNightWeekendShared;
    private C1Data bal_VoiceAnytimeShared;

    public AB_DIYSuperPack() {
        setOfferName("DIY - Super-Pack");
        setOfferDescription("DIY allows you to extensively customize your services.");
        setOfferTermsAndConditions("DIY - Super-Pack Terms and Conditions.");

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
