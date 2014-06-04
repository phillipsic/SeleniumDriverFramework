package com.comverse.css.data.PO;

import com.comverse.css.data.C1Data;
import com.comverse.css.data.Offer;
import com.comverse.css.data.BAL.BAL_GPRS_WAP_INTERNET;

public class PO_ResidentialUltraPostpaid15DiscountICB extends Offer {
	
    private C1Data bal_GPRS_WAP_INTERNET;
    
    public PO_ResidentialUltraPostpaid15DiscountICB() {
        setOfferName("Residential - Postpaid 15% discount ICB");
        
        bal_GPRS_WAP_INTERNET = new BAL_GPRS_WAP_INTERNET();
    }
    
    @Override
    public C1Data getBAL_GPRS_WAP_INTERNET() {
        return bal_GPRS_WAP_INTERNET;
    }
}
