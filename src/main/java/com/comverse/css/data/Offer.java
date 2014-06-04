package com.comverse.css.data;

public abstract class Offer extends C1Data {

    private String offerName;
    private String newOfferName;
    private String offerEmail;
    private String offerDescription;
    private String offerCustomerType;
    private String offerNetworkType;
    private String offerTermsAndConditions;
    private String recurringChargeCycle;
    private String engagementDuriation;
    private boolean termsAndConditions;
    private String RC;
    private String NRC;
    private String currency = "$";

    public Offer() {
        setOfferName(null);
        setNewOfferName(null);
        setOfferDescription(null);
        setOfferCustomerType(null);
        setOfferNetworkType(null);
        setOfferEmail(null);
        setOfferTermsAndConditions(null);
        setTermsAndConditions(false);
        setRC("0");
        setNRC("0");
        setRecurringChargeCycle(null);
        setEngagementDuration(null);
    }

    @Override
    public String getOfferName() {
        return offerName;
    }

    public String getNewOfferName() {
        return newOfferName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public void setNewOfferName(String newOfferName) {
        this.newOfferName = newOfferName;
    }

    public String getOfferEmail() {
        return offerEmail;
    }

    public void setOfferEmail(String offerEmail) {
        this.offerEmail = offerEmail;
    }

    public String getEngagementDuration() {
        return engagementDuriation;
    }

    public void setEngagementDuration(String engagementDuriation) {
        this.engagementDuriation = engagementDuriation;
    }

    public String getRecurringChargeCycle() {
        return recurringChargeCycle;
    }

    public void setRecurringChargeCycle(String recurringChargeCycle) {
        this.recurringChargeCycle = recurringChargeCycle;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getOfferCustomerType() {
        return offerCustomerType;
    }

    public void setOfferCustomerType(String offerCustomerType) {
        this.offerCustomerType = offerCustomerType;
    }

    public String getOfferNetworkType() {
        return offerNetworkType;
    }

    public void setOfferNetworkType(String offerNetworkType) {
        this.offerNetworkType = offerNetworkType;
    }

    public String getOfferTermsAndConditions() {
        return offerTermsAndConditions;
    }

    public void setOfferTermsAndConditions(String offerTermsAndConditions) {
        this.offerTermsAndConditions = offerTermsAndConditions;
    }

    public boolean isTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(boolean termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getRC() {
        return RC;
    }

    public void setRC(String rC) {
        RC = rC;
    }

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String nRC) {
        NRC = nRC;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Offer getSO_DIYeFIRSTSelectService4ExtendedInteractionTVSuperBundle() {
        return null;
    }

    public Offer getSO_DIYeSECONDSelectService4ExtendedInteractionTVSuperBundle() {
        return null;
    }
}
