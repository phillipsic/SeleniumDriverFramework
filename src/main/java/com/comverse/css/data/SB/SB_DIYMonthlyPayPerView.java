package com.comverse.css.data.SB;

import com.comverse.css.data.C1Data;
import com.comverse.css.data.Offer;
import com.comverse.css.data.PO.PO_DIYMonthlyPayPerView;

public class SB_DIYMonthlyPayPerView extends Offer {
    private C1Data po_DIYMonthlySubscriptionPrimeOffering;

    public SB_DIYMonthlyPayPerView() {
        setOfferName("DIY - Monthly PayPerView ( with cCi)");
        po_DIYMonthlySubscriptionPrimeOffering = new PO_DIYMonthlyPayPerView();
    }

    public C1Data getPO_DIYMonthlySubscriptionPrimeOffering() {
        return po_DIYMonthlySubscriptionPrimeOffering;
    }
}
