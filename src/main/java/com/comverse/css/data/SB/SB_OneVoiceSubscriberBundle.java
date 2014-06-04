package com.comverse.css.data.SB;

import com.comverse.css.data.C1Data;
import com.comverse.css.data.Offer;
import com.comverse.css.data.PO.PO_OneVoiceVoice;

public class SB_OneVoiceSubscriberBundle extends Offer {
    private C1Data po_OneVoiceVoice;

    public SB_OneVoiceSubscriberBundle() {
        setOfferName("OneVoice Subscriber Bundle");
        po_OneVoiceVoice = new PO_OneVoiceVoice();
    }

    public C1Data getPO_OneVoiceVoice() {
        return po_OneVoiceVoice;
    }
}
