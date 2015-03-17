package com.company.css.data.SB;

import com.company.css.data.C1Data;
import com.company.css.data.Offer;
import com.company.css.data.PO.PO_OneVoiceVoice;

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
