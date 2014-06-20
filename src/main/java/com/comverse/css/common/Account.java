package com.comverse.css.common;

import com.comverse.css.data.C1Data;

public class Account extends C1Data {

    private String billingCompanyName;
    private String billingLastName;
    private String billingFirstName;
    private String billingAccountID;
    private String billingGender;
    private String billingTitle;
    private String billingHomeCountry;
    private String billingHomeState;
    private String billingStreetNumber;
    private String billingStreetName;
    private String billingCity;
    private String billingPostCode;
    private String billingEmail;
    private String billingPhone;
    private String billingFax;
    private String billingPaymentMethod;
    private String billingBankCode;
    private String billingBankAgencyCode;
    private String billingBankAccountNumber;
    private String billingCustomerSocialSecurityNumber;
    private String billingPurchaseOrder;
    private String billingSalesCode;
    private String billingSecurityWord;
    private String billingSICCode;
    private String billingBillDispatchMethod;
    private String billingBillFormatOption;
    private String billingExchangeRateClass;
    private String billingTML;
    private String billingVIPCode;
    private String billingBillPeriod;

    public Account(String uniqueTimeStamp) {
        setBillingCompanyNameProperty("Company" + uniqueTimeStamp);
        setBillingLastNameProperty("BillingLN" + uniqueTimeStamp);
        setBillingFirstNameProperty("BillingFN" + uniqueTimeStamp);
        setBillingAccountIDProperty(null);
        setBillingGenderProperty("male");
        setBillingTitleProperty("Mr.");
        setBillingHomeCountryProperty("United States");
        setBillingHomeStateProperty("Colorado");
        setBillingStreetNumberProperty("Billing55");
        setBillingStreetNameProperty("BillingStreet");
        setBillingCityProperty("BillingCity");
        setBillingPostCodeProperty("612204");
        setBillingEmailProperty("BillingEmail");
        setBillingPhoneProperty("BillingPhone");
        setBillingFaxProperty("BillingFax");
        setBillingPaymentMethodProperty("Check");
        setBillingBankCodeProperty("123456789");
        setBillingBankAgencyCodeProperty("13456");
        setBillingBankAccountNumberProperty("145678901234567890123465790123");
        setBillingCustomerSocialSecurityNumberProperty("1");
        setBillingPurchaseOrderProperty("2");
        setBillingSalesCodeProperty("3");
        setBillingSecurityWordProperty("4");
        setBillingSICCodeProperty("5");
        setBillingBillDispatchMethodProperty("Paperless");
        setBillingBillFormatOptionProperty("Prepaid Statement");
        setBillingExchangeRateClassProperty("Exchange Rate 3");
        setBillingTMLProperty("yes");
        setBillingVIPCodeProperty("VIP");
        setBillingBillPeriodProperty("1st of every month");
    }

    public Account() {
    }

    public String getBillingCompanyNameProperty() {
        return billingCompanyName;
    }

    public String getBillingLastNameProperty() {
        return billingLastName;
    }

    public String getBillingFirstNameProperty() {
        return billingFirstName;
    }

    public String getBillingAccountIDProperty() {
        return billingAccountID;
    }

    public String getBillingGenderProperty() {
        return billingGender;
    }

    public String getBillingTitleProperty() {
        return billingTitle;
    }

    public String getBillingHomeCountryProperty() {
        return billingHomeCountry;
    }

    public String getBillingHomeStateProperty() {
        return billingHomeState;
    }

    public String getBillingStreetNumberProperty() {
        return billingStreetNumber;
    }

    public String getBillingStreetNameProperty() {
        return billingStreetName;
    }

    public String getBillingCityProperty() {
        return billingCity;
    }

    public String getBillingPostCodeProperty() {
        return billingPostCode;
    }

    public String getBillingPaymentMethodProperty() {
        return billingPaymentMethod;
    }

    public String getBillingEmailProperty() {
        return billingEmail;
    }

    public String getBillingPhoneProperty() {
        return billingPhone;
    }

    public String getBillingFaxProperty() {
        return billingFax;
    }

    public String getBillingBankCodeProperty() {
        return billingBankCode;
    }

    public String getBillingBankAgencyCodeProperty() {
        return billingBankAgencyCode;
    }

    public String getBillingBankAccountNumberProperty() {
        return billingBankAccountNumber;
    }

    public String getBillingCustomerSocialSecurityNumberProperty() {
        return billingCustomerSocialSecurityNumber;
    }

    public String getBillingPurchaseOrderProperty() {
        return billingPurchaseOrder;
    }

    public String getBillingSalesCodeProperty() {
        return billingSalesCode;
    }

    public String getBillingSecurityWordProperty() {
        return billingSecurityWord;
    }

    public String getBillingSICCodeProperty() {
        return billingSICCode;
    }

    public String getBillingBillDispatchMethodProperty() {
        return billingBillDispatchMethod;
    }

    public String getBillingBillFormatOptionProperty() {
        return billingBillFormatOption;
    }

    public String getBillingExchangeRateClassProperty() {
        return billingExchangeRateClass;
    }

    public String getBillingTMLProperty() {
        return billingTML;
    }

    public String getBillingVIPCodeProperty() {
        return billingVIPCode;
    }

    public String getBillingBillPeriodProperty() {
        return billingBillPeriod;
    }

    public void setBillingCompanyNameProperty(String billingCompanyName) {
        System.out.println("set billingCompanyName = " + billingCompanyName);
        this.billingCompanyName = billingCompanyName;
    }

    public void setBillingLastNameProperty(String billingLastName) {
        System.out.println("set billingLastName = " + billingLastName);
        this.billingLastName = billingLastName;
    }

    public void setBillingFirstNameProperty(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public void setBillingAccountIDProperty(String billingAccountID) {
        System.out.println("set billingAccountID = " + billingAccountID);
        this.billingAccountID = billingAccountID;
    }

    public void setBillingGenderProperty(String billingGender) {
        this.billingGender = billingGender;
    }

    public void setBillingTitleProperty(String billingTitle) {
        this.billingTitle = billingTitle;
    }

    public void setBillingHomeCountryProperty(String billingHomeCountry) {
        this.billingHomeCountry = billingHomeCountry;
    }

    public void setBillingHomeStateProperty(String billingHomeState) {
        this.billingHomeState = billingHomeState;
    }

    public void setBillingStreetNumberProperty(String billingStreetNumber) {
        this.billingStreetNumber = billingStreetNumber;
    }

    public void setBillingStreetNameProperty(String billingStreetName) {
        this.billingStreetName = billingStreetName;
    }

    public void setBillingCityProperty(String billingCity) {
        this.billingCity = billingCity;
    }

    public void setBillingPostCodeProperty(String billingPostCode) {
        this.billingPostCode = billingPostCode;
    }

    public void setBillingPaymentMethodProperty(String billingPaymentMethod) {
        this.billingPaymentMethod = billingPaymentMethod;
    }

    public void setBillingEmailProperty(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public void setBillingPhoneProperty(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public void setBillingFaxProperty(String billingFax) {
        this.billingFax = billingFax;
    }

    public void setBillingBankCodeProperty(String billingBankCode) {
        this.billingBankCode = billingBankCode;
    }

    public void setBillingBankAgencyCodeProperty(String billingBankAgencyCode) {
        this.billingBankAgencyCode = billingBankAgencyCode;
    }

    public void setBillingBankAccountNumberProperty(String billingBankAccountNumber) {
        this.billingBankAccountNumber = billingBankAccountNumber;
    }

    public void setBillingCustomerSocialSecurityNumberProperty(String billingCustomerSocialSecurityNumber) {
        this.billingCustomerSocialSecurityNumber = billingCustomerSocialSecurityNumber;
    }

    public void setBillingPurchaseOrderProperty(String billingPurchaseOrder) {
        this.billingPurchaseOrder = billingPurchaseOrder;
    }

    public void setBillingSalesCodeProperty(String billingSalesCode) {
        this.billingSalesCode = billingSalesCode;
    }

    public void setBillingSecurityWordProperty(String billingSecurityWord) {
        this.billingSecurityWord = billingSecurityWord;
    }

    public void setBillingSICCodeProperty(String billingSICCode) {
        this.billingSICCode = billingSICCode;
    }

    public void setBillingBillDispatchMethodProperty(String billingBillDispatchMethod) {
        this.billingBillDispatchMethod = billingBillDispatchMethod;
    }

    public void setBillingBillFormatOptionProperty(String billingBillFormatOption) {
        this.billingBillFormatOption = billingBillFormatOption;
    }

    public void setBillingExchangeRateClassProperty(String billingExchangeRateClass) {
        this.billingExchangeRateClass = billingExchangeRateClass;
    }

    public void setBillingTMLProperty(String billingTML) {
        this.billingTML = billingTML;
    }

    public void setBillingVIPCodeProperty(String billingVIPCode) {
        this.billingVIPCode = billingVIPCode;
    }

    public void setBillingBillPeriodProperty(String billingBillPeriod) {
        this.billingBillPeriod = billingBillPeriod;
    }

}
