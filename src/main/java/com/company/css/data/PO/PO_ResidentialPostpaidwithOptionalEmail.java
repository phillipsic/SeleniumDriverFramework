package com.company.css.data.PO;

import com.company.css.data.Offer;
import com.company.css.data.BAL.BAL_GPRS_WAP_INTERNET;

public class PO_ResidentialPostpaidwithOptionalEmail extends Offer {

    private BAL_GPRS_WAP_INTERNET bal_GPRS_WAP_INTERNET;

    public PO_ResidentialPostpaidwithOptionalEmail() {
        setOfferName("Residential Postpaid with Optional Email");
        setOfferEmail("email@company.com");
        bal_GPRS_WAP_INTERNET = new BAL_GPRS_WAP_INTERNET();
    }

    @Override
	public BAL_GPRS_WAP_INTERNET getBAL_GPRS_WAP_INTERNET() {
        return bal_GPRS_WAP_INTERNET;
    }
}
