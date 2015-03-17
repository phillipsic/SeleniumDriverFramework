package com.company.css.data.AB;

import com.company.css.data.Offer;
import com.company.css.data.SB.SB_DIYeExtendedInteractionTVSuperBundle;

public class AB_DIYeExtendedInteractionTVSuperPack extends Offer {
    private Offer sb_DIYeExtendedInteractionTVSuperBundle;

    public AB_DIYeExtendedInteractionTVSuperPack() {
        setOfferName("DIYe - Extended-Interaction TV Super-Pack");
        sb_DIYeExtendedInteractionTVSuperBundle = new SB_DIYeExtendedInteractionTVSuperBundle();
    }

    public Offer getSB_DIYeExtendedInteractionTVSuperBundle() {
        return sb_DIYeExtendedInteractionTVSuperBundle;
    }

}
