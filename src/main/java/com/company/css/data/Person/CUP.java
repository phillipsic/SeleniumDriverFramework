package com.company.css.data.Person;

import com.framework.app.common.Subscriber;
import com.company.css.data.Offer;
import com.company.css.data.PO.PO_WilsonCometPlan;

public class CUP extends Subscriber {

    private Subscriber sub;
    private PO_WilsonCometPlan po_WilsonCometPlan;

    public CUP() {
        super();

        sub = new Subscriber();
        sub.setSubscriberLastNameProperty("Karen");
        sub.setSubscriberFirstNameProperty("Smith");
        sub.setSubscriberMSISDNProperty("8861245987");
        po_WilsonCometPlan = new PO_WilsonCometPlan();
    }

    @Override
    public Subscriber getSubscriber() {
        return sub;
    }

    @Override
    public Offer getOffer() {
        return po_WilsonCometPlan;
    }
}
