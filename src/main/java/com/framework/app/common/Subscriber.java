package com.framework.app.common;

import com.company.css.data.C1Data;

public class Subscriber extends C1Data {

    private String subscriberLastNameProperty;
    private String subscriberFirstNameProperty;
    private String subscriberGenderProperty;
    private String subscriberTitleProperty;
    private String subscriberHomeCountryProperty;
    private String subscriberHomeStateProperty;
    private String subscriberStreetNumberProperty;
    private String subscriberStreetNameProperty;
    private String subscriberCityProperty;
    private String subscriberPostCodeProperty;
    private String subscriberBirthdayProperty;
    private String subscriberSecurityWordProperty;
    private String subscriberLanguageProperty;
    private String subscriberDayPhoneNumberProperty;
    private String subscriberEveningPhoneNumberProperty;
    private String subscriberMSISDNProperty;
    private String subscriberIMSIProperty;
    private String subscriberSIMProperty;
    private String subscriberTVQualityProperty;
    private String subscriberHappyHourStartProperty;
    private String subscriberHappyHourEndProperty;

    public Subscriber(String uniqueTimeStamp) {
        setSubscriberLastNameProperty("SubscriberLN" + uniqueTimeStamp);
        setSubscriberFirstNameProperty("SubscriberFN" + uniqueTimeStamp);
        setSubscriberGenderProperty("female");
        setSubscriberTitleProperty("Miss");
        setSubscriberHomeCountryProperty("United States");
        setSubscriberHomeStateProperty("Hawaii");
        setSubscriberStreetNumberProperty("Subscrib55");
        setSubscriberStreetNameProperty("SubscriberStreet");
        setSubscriberCityProperty("SubscriberCity");
        setSubscriberPostCodeProperty("Subscriber78600");
        setSubscriberBirthdayProperty("03/13/1976");
        setSubscriberSecurityWordProperty("SecWord");
        setSubscriberLanguageProperty("French");
        setSubscriberDayPhoneNumberProperty("0123456789");
        setSubscriberEveningPhoneNumberProperty("0623456789");
        setSubscriberMSISDNProperty(null);
        setSubscriberIMSIProperty(null);
        setSubscriberSIMProperty(null);
        setSubscriberTVQualityProperty(null);
        setSubscriberHappyHourStartProperty("16");
        setSubscriberHappyHourEndProperty("18");
    }

    public Subscriber() {
    }

    public String getSubscriberLastNameProperty() {
        return subscriberLastNameProperty;
    }

    public void setSubscriberLastNameProperty(String subscriberLastNameProperty) {
        System.out.println("set SubscriberLastNameProperty = " + subscriberLastNameProperty);
        this.subscriberLastNameProperty = subscriberLastNameProperty;
    }

    public String getSubscriberFirstNameProperty() {
        return subscriberFirstNameProperty;
    }

    public void setSubscriberFirstNameProperty(String subscriberFirstNameProperty) {
        this.subscriberFirstNameProperty = subscriberFirstNameProperty;
    }

    public String getSubscriberGenderProperty() {
        return subscriberGenderProperty;
    }

    public void setSubscriberGenderProperty(String subscriberGenderProperty) {
        this.subscriberGenderProperty = subscriberGenderProperty;
    }

    public String getSubscriberTitleProperty() {
        return subscriberTitleProperty;
    }

    public void setSubscriberTitleProperty(String subscriberTitleProperty) {
        this.subscriberTitleProperty = subscriberTitleProperty;
    }

    public String getSubscriberHomeCountryProperty() {
        return subscriberHomeCountryProperty;
    }

    public void setSubscriberHomeCountryProperty(String subscriberHomeCountryProperty) {
        this.subscriberHomeCountryProperty = subscriberHomeCountryProperty;
    }

    public String getSubscriberHomeStateProperty() {
        return subscriberHomeStateProperty;
    }

    public void setSubscriberHomeStateProperty(String subscriberHomeStateProperty) {
        this.subscriberHomeStateProperty = subscriberHomeStateProperty;
    }

    public String getSubscriberStreetNumberProperty() {
        return subscriberStreetNumberProperty;
    }

    public void setSubscriberStreetNumberProperty(String subscriberStreetNumberProperty) {
        this.subscriberStreetNumberProperty = subscriberStreetNumberProperty;
    }

    public String getSubscriberStreetNameProperty() {
        return subscriberStreetNameProperty;
    }

    public void setSubscriberStreetNameProperty(String subscriberStreetNameProperty) {
        this.subscriberStreetNameProperty = subscriberStreetNameProperty;
    }

    public String getSubscriberCityProperty() {
        return subscriberCityProperty;
    }

    public void setSubscriberCityProperty(String subscriberCityProperty) {
        this.subscriberCityProperty = subscriberCityProperty;
    }

    public String getSubscriberPostCodeProperty() {
        return subscriberPostCodeProperty;
    }

    public void setSubscriberPostCodeProperty(String subscriberPostCodeProperty) {
        this.subscriberPostCodeProperty = subscriberPostCodeProperty;
    }

    public String getSubscriberSecurityWordProperty() {
        return subscriberSecurityWordProperty;
    }

    public void setSubscriberSecurityWordProperty(String subscriberSecurityWordProperty) {
        this.subscriberSecurityWordProperty = subscriberSecurityWordProperty;
    }

    public String getSubscriberLanguageProperty() {
        return subscriberLanguageProperty;
    }

    public void setSubscriberLanguageProperty(String subscriberLanguageProperty) {
        this.subscriberLanguageProperty = subscriberLanguageProperty;
    }

    public String getSubscriberBirthdayProperty() {
        return subscriberBirthdayProperty;
    }

    public void setSubscriberBirthdayProperty(String subscriberBirthdayProperty) {
        this.subscriberBirthdayProperty = subscriberBirthdayProperty;
    }

    public String getSubscriberDayPhoneNumberProperty() {
        return subscriberDayPhoneNumberProperty;
    }

    public void setSubscriberDayPhoneNumberProperty(String subscriberDayPhoneNumberProperty) {
        this.subscriberDayPhoneNumberProperty = subscriberDayPhoneNumberProperty;
    }

    public String getSubscriberEveningPhoneNumberProperty() {
        return subscriberEveningPhoneNumberProperty;
    }

    public void setSubscriberEveningPhoneNumberProperty(String subscriberEveningPhoneNumberProperty) {
        this.subscriberEveningPhoneNumberProperty = subscriberEveningPhoneNumberProperty;
    }

    public String getSubscriberMSISDNProperty() {
        return subscriberMSISDNProperty;
    }

    public void setSubscriberMSISDNProperty(String subscriberMSISDNProperty) {
        System.out.println("set SubscriberMSISDNProperty = " + subscriberMSISDNProperty);
        this.subscriberMSISDNProperty = subscriberMSISDNProperty;
    }

    public String getSubscriberIMSIProperty() {
        return subscriberIMSIProperty;
    }

    public void setSubscriberIMSIProperty(String subscriberIMSIProperty) {
        this.subscriberIMSIProperty = subscriberIMSIProperty;
    }

    public String getSubscriberSIMProperty() {
        return subscriberSIMProperty;
    }

    public void setSubscriberSIMProperty(String subscriberSIMProperty) {
        this.subscriberSIMProperty = subscriberSIMProperty;
    }

    public String getSubscriberTVQualityProperty() {
        return subscriberTVQualityProperty;
    }

    public void setSubscriberTVQualityProperty(String subscriberTVQualityProperty) {
        this.subscriberTVQualityProperty = subscriberTVQualityProperty;
    }

    public String getSubscriberHappyHourStartProperty() {
        return subscriberHappyHourStartProperty;
    }

    public void setSubscriberHappyHourStartProperty(String subscriberHappyHourStartProperty) {
        this.subscriberHappyHourStartProperty = subscriberHappyHourStartProperty;
    }

    public String getSubscriberHappyHourEndProperty() {
        return subscriberHappyHourEndProperty;
    }

    public void setSubscriberHappyHourEndProperty(String subscriberHappyHourEndProperty) {
        this.subscriberHappyHourEndProperty = subscriberHappyHourEndProperty;
    }

}
