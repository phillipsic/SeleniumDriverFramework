package com.comverse.css.data.Person;

import com.framework.app.common.Subscriber;
import com.comverse.css.data.Offer;
import com.comverse.css.data.PO.PO_HaleyCometPlan;

public class CMP extends Subscriber {

    private Subscriber sub;
    private PO_HaleyCometPlan po_HaleyCometPlan;

    public CMP() {
        super();

        sub = new Subscriber();
        sub.setSubscriberLastNameProperty("Dave");
        sub.setSubscriberFirstNameProperty("Smith");
        sub.setSubscriberMSISDNProperty("18564440112");
        po_HaleyCometPlan = new PO_HaleyCometPlan();
    }

    @Override
    public Subscriber getSubscriber() {
        return sub;
    }

    @Override
    public Offer getOffer() {
        return po_HaleyCometPlan;
    }
}
