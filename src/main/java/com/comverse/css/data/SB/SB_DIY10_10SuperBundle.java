package com.comverse.css.data.SB;

import com.comverse.css.data.C1Data;
import com.comverse.css.data.Offer;
import com.comverse.css.data.BAL.BAL_SOURCE_Monetary;
import com.comverse.css.data.PO.PO_DIYInteractiveTVOfferforAll;
import com.comverse.css.data.SO.SO_DIYAdditionalTVServices4U;

public class SB_DIY10_10SuperBundle extends Offer {
    private C1Data po_DIYInteractiveTVOfferforAll;
    private C1Data so_DIYAdditionalTVServices4U;
    private C1Data bal_SOURCE_Monetary;

    public SB_DIY10_10SuperBundle() {
        setOfferName("DIY - 10 / 10 Super Bundle");
        setOfferDescription("DIY - 10 / 10 Super Bundle is the pack to go.");
        setOfferTermsAndConditions("DIY - 10/10 Super Bundle Terms and Conditions");
        po_DIYInteractiveTVOfferforAll = new PO_DIYInteractiveTVOfferforAll();
        so_DIYAdditionalTVServices4U = new SO_DIYAdditionalTVServices4U();
        bal_SOURCE_Monetary = new BAL_SOURCE_Monetary();
    }

    public C1Data getPO_DIYInteractiveTVOfferforAll() {
        return po_DIYInteractiveTVOfferforAll;
    }

    public C1Data getSO_DIYAdditionalTVServices4U() {
        return so_DIYAdditionalTVServices4U;
    }

    public C1Data getBAL_SOURCE_Monetary() {
        return bal_SOURCE_Monetary;
    }

}
