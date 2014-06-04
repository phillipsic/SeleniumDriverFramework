package com.comverse.css.data.SB;

import com.comverse.css.data.C1Data;
import com.comverse.css.data.Offer;
import com.comverse.css.data.PO.PO_DIYeExtendedInteractionTVPrimeOfferVIPOnly;
import com.comverse.css.data.SO.SO_DIYeFIRSTSelectService4ExtendedInteractionTVSuperBundle;
import com.comverse.css.data.SO.SO_DIYeSECONDSelectService4ExtendedInteractionTVSuperBundle;

public class SB_DIYeExtendedInteractionTVSuperBundle extends Offer {
    private C1Data po_DIYeExtendedInteractionTVPrimeOfferVIPOnly;
    private Offer so_DIYeFIRSTSelectService4ExtendedInteractionTVSuperBundle;
    private Offer so_DIYeSECONDSelectService4ExtendedInteractionTVSuperBundle;

    public SB_DIYeExtendedInteractionTVSuperBundle() {
        setOfferName("DIYe - Extended-Interaction TV Super Bundle");
        po_DIYeExtendedInteractionTVPrimeOfferVIPOnly = new PO_DIYeExtendedInteractionTVPrimeOfferVIPOnly();
        so_DIYeFIRSTSelectService4ExtendedInteractionTVSuperBundle = new SO_DIYeFIRSTSelectService4ExtendedInteractionTVSuperBundle();
        so_DIYeSECONDSelectService4ExtendedInteractionTVSuperBundle = new SO_DIYeSECONDSelectService4ExtendedInteractionTVSuperBundle();
    }

    public C1Data getPO_DIYeExtendedInteractionTVPrimeOfferVIPOnly() {
        return po_DIYeExtendedInteractionTVPrimeOfferVIPOnly;
    }

    @Override
    public Offer getSO_DIYeFIRSTSelectService4ExtendedInteractionTVSuperBundle() {
        return so_DIYeFIRSTSelectService4ExtendedInteractionTVSuperBundle;
    }

    @Override
    public Offer getSO_DIYeSECONDSelectService4ExtendedInteractionTVSuperBundle() {
        return so_DIYeSECONDSelectService4ExtendedInteractionTVSuperBundle;
    }
}