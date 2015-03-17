package com.company.css.data.PO;

import com.company.css.data.C1Data;
import com.company.css.data.Offer;
import com.company.css.data.BAL.BAL_CORE_BALANCE;
import com.company.css.data.BAL.BAL_GPRS_WAP_INTERNET;
import com.company.css.data.BAL.BAL_InternationalRoaming;

public class PO_ResidentialUltraPostpaid extends Offer {

    private C1Data bal_GPRS_WAP_INTERNET;
    private C1Data bal_InternationalRoaming;
    private C1Data bal_CORE_BALANCE;

    public PO_ResidentialUltraPostpaid() {
        setOfferName("Residential - Ultra Postpaid");
        setOfferCustomerType("Residential");
        setOfferNetworkType("GSM Mobile");
        setRC("30.00");
        setNRC("22.00");
        setRecurringChargeCycle("Monthly");
        setEngagementDuration("Contract 365 days");

        bal_GPRS_WAP_INTERNET = new BAL_GPRS_WAP_INTERNET();
        bal_InternationalRoaming = new BAL_InternationalRoaming();
        bal_CORE_BALANCE = new BAL_CORE_BALANCE();

    }

    @Override
    public C1Data getBAL_GPRS_WAP_INTERNET() {
        return bal_GPRS_WAP_INTERNET;
    }

    public C1Data getBAL_InternationalRoaming() {
        return bal_InternationalRoaming;
    }

    public C1Data getBAL_CORE_BALANCE() {
        return bal_CORE_BALANCE;
    }

}
