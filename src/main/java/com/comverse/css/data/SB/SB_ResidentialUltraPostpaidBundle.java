package com.comverse.css.data.SB;

import com.comverse.css.data.C1Data;
import com.comverse.css.data.Offer;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;

public class SB_ResidentialUltraPostpaidBundle extends Offer {
    private C1Data po_ResidentialUltraPostpaid;

    public SB_ResidentialUltraPostpaidBundle() {
        setOfferName("Residential - Ultra Postpaid Bundle");
        setOfferNetworkType("GSM Mobile");
        po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
    }

    public C1Data getPO_ResidentialUltraPostpaid() {
        return po_ResidentialUltraPostpaid;
    }
}
