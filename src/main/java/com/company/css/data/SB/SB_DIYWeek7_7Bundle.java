package com.company.css.data.SB;

import com.company.css.data.C1Data;
import com.company.css.data.Offer;
import com.company.css.data.PO.PO_DIYWeeklySubscriptionPrimeOffering;

public class SB_DIYWeek7_7Bundle extends Offer {
    private C1Data po_DIYWeeklySubscriptionPrimeOffering;

    public SB_DIYWeek7_7Bundle() {
        setOfferName("DIY - Week 7-7 Bundle.");
        po_DIYWeeklySubscriptionPrimeOffering = new PO_DIYWeeklySubscriptionPrimeOffering();
    }

    public C1Data getPO_DIYWeeklySubscriptionPrimeOffering() {
        return po_DIYWeeklySubscriptionPrimeOffering;
    }
}
