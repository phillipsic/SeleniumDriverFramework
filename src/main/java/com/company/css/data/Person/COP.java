package com.company.css.data.Person;

import com.company.css.common.Account;
import com.framework.app.common.Person;
import com.framework.app.common.Subscriber;
import com.company.css.data.Offer;
import com.company.css.data.PO.PO_HaleyCometPlan;

public class COP extends Person {

    private Account acnt;
    private Subscriber sub;
    private PO_HaleyCometPlan po_HaleyCometPlan;

    public COP() {
        super();
        setPersonLastNameProperty("Smith");
        setPersonFirstNameProperty("Tammy");
        acnt = new Account();
        acnt.setBillingAccountIDProperty("111222333");
        sub = new Subscriber();
        sub.setSubscriberLastNameProperty(this.getPersonLastNameProperty());
        sub.setSubscriberFirstNameProperty(this.getPersonFirstNameProperty());
        sub.setSubscriberMSISDNProperty("0660100099");
        po_HaleyCometPlan = new PO_HaleyCometPlan();
    }

    @Override
    public Account getAccount() {
        return acnt;
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
