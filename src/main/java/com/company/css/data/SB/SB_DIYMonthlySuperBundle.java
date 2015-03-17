package com.company.css.data.SB;

import com.company.css.data.C1Data;
import com.company.css.data.Offer;
import com.company.css.data.PO.PO_DIYMonthlyPayPerView;

public class SB_DIYMonthlySuperBundle extends Offer {
    private C1Data po_DIYMonthlySubscriptionPrimeOffering;

    public SB_DIYMonthlySuperBundle() {
        setOfferName("DIY - Monthly Super Bundle");
        po_DIYMonthlySubscriptionPrimeOffering = new PO_DIYMonthlyPayPerView();
    }

    public C1Data getPO_DIYMonthlySubscriptionPrimeOffering() {
        return po_DIYMonthlySubscriptionPrimeOffering;
    }
}
