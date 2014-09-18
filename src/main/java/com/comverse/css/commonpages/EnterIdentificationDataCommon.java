/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.Application;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;
import com.comverse.css.common.Person;
import com.comverse.css.common.Subscriber;

public class EnterIdentificationDataCommon extends CommonMenu {

    public EnterIdentificationDataCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Customer Acquisition - Identification Data";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setGender(String gender) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + gender + ")");

        boolean correctGender = false;

        if (gender.equalsIgnoreCase("male")) {
            tool.clickUsingID("sex_male");
            correctGender = true;
        }

        if (gender.equalsIgnoreCase("female")) {
            tool.clickUsingID("sex_fem");
            correctGender = true;
        }

        if (!correctGender) {
            throw new IllegalStateException("Gender not recognised - male or female: " + gender);

        }
    }

    public void setNationality(String title) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + title + ")");

        tool.selectVisibleTextByID("nationality", title);
    }

    public void setLanguage(String title) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + title + ")");

        tool.selectVisibleTextByID("language", title);
    }

    public void setEmailAddress(String email) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + email + ")");

        tool.enterStringUsingId("email", email);
    }

    public void setPhoneNumber(String phonenumber) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + phonenumber + ")");
        tool.enterStringUsingId("home_phone", phonenumber);
    }

    public void setMobileNumber(String mobile_phone) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + mobile_phone + ")");

        tool.enterStringUsingId("mobile_phone", mobile_phone);
    }

    public void setFaxNumber(String fax) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + fax + ")");

        tool.enterStringUsingId("fax", fax);
    }

    public void setNationalID(String national_id) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + national_id + ")");

        tool.enterStringUsingId("national_id", national_id);
    }

    public void setDateOfBirth(String date_of_birth) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + date_of_birth + ")");

        tool.enterStringUsingId("date_of_birth", date_of_birth);
    }

    public void setBillingTitle(String title) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + title + ")");
        tool.selectVisibleTextByID("billing_title", title);
    }

    public void setBusinessTitle(String title) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + title + ")");
        tool.selectVisibleTextByID("contact_title_field", title);
    }

    public void setBillingFirstName(String billing_first_name) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_first_name + ")");

        tool.enterStringUsingId("billing_first_name", billing_first_name);
    }

    public void setBusinessFirstName(String biz_first_name) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + biz_first_name + ")");

        tool.enterStringUsingId("first_name", biz_first_name);
    }

    public void setBillingLastName(String billing_last_name) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_last_name + ")");

        tool.enterStringUsingId("billing_last_name", billing_last_name);
    }

    public void setBusinessLastName(String biz_last_name) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + biz_last_name + ")");

        tool.enterStringUsingId("last_name", biz_last_name);
    }

    public void setBillingStreetName(String billing_streetName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_streetName + ")");

        tool.enterStringUsingId("billing_streetName", billing_streetName);
    }

    public void setBillingStreetSuffix(String billing_streetSuffix) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_streetSuffix + ")");
        tool.selectVisibleTextByID("billing_streetSuffix", billing_streetSuffix);
    }

    public void setBillingStreetNumber(String billing_streetNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_streetNumber + ")");

        tool.enterStringUsingId("billing_streetNumber", billing_streetNumber);
    }

    public void enterBillingPostCode(String billing_zip_code) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_zip_code + ")");

        tool.enterStringUsingId("billing_zip_code", billing_zip_code);
    }

    public void enterBillingHomeCountry(String billing_country) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_country + ")");
        tool.selectVisibleTextByID("billing_country", billing_country);
    }

    public void enterBillingHomeState(String billing_state) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_state + ")");
        tool.selectVisibleTextByID("billing_state", billing_state);
    }

    public void enterBillingCity(String billing_city) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_city + ")");

        tool.enterStringUsingId("billing_city", billing_city);
    }

    public void enterBusinessPostCode(String billing_zip_code) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_zip_code + ")");

        tool.enterStringUsingId("home_zip", billing_zip_code);
    }

    public void enterBusinessHomeCountry(String billing_country) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_country + ")");
        tool.selectVisibleTextByID("home_country", billing_country);
    }

    public void enterBusinessHomeState(String billing_state) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_state + ")");
        tool.selectVisibleTextByID("home_state", billing_state);
    }

    public void enterBusinessCity(String billing_city) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + billing_city + ")");

        tool.enterStringUsingId("home_city", billing_city);
    }

    public void setCustomerTitle(String title) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + title + ")");
        tool.selectVisibleTextByID("contact_title_field", title);
    }

    public void setCustomerFirstName(String firstname) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + firstname + ")");

        tool.enterStringUsingId("first_name", firstname);
    }

    public void setCustomerLastName(String lastname) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + lastname + ")");

        tool.enterStringUsingId("last_name", lastname);
    }

    public void setCustomerStreetName(String streetName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + streetName + ")");

        tool.enterStringUsingId("streetName", streetName);
    }

    public void setCustomerStreetSuffix(String streetSuffix) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + streetSuffix + ")");
        tool.selectVisibleTextByID("streetSuffix", streetSuffix);
    }

    public void setCustomerStreetNumber(String streetNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + streetNumber + ")");

        tool.enterStringUsingId("streetNumber", streetNumber);
    }

    public String getCustomerStreetName() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getAttributeUsingId("streetName", "value");
    }

    public void enterCustomerPostCode(String postCode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + postCode + ")");

        tool.enterStringUsingId("home_zip", postCode);
    }

    public String getCustomerPostCode() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getAttributeUsingId("home_zip", "value");
    }

    public void enterCustomerHomeCountry(String homeCountry) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + homeCountry + ")");
        tool.selectVisibleTextByID("home_country", homeCountry);
    }

    public String getCustomerHomeCountry() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getSelectedTextByID("home_country");
    }

    public void enterCustomerHomeState(String homeState) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + homeState + ")");
        tool.selectVisibleTextByID("home_state", homeState);
    }

    public void enterCustomerCity(String city) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + city + ")");

        tool.enterStringUsingId("home_city", city);
    }

    public String getCustomerCity() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getAttributeUsingId("home_city", "value");
    }

    public void setServiceTitle(String service_title) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_title + ")");
        tool.selectVisibleTextByID("service_title", service_title);
    }

    public void setServiceFirstName(String service_first_name) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_first_name + ")");

        tool.enterStringUsingId("service_first_name", service_first_name);
    }

    public void setServiceLastName(String service_last_name) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_last_name + ")");

        tool.enterStringUsingId("service_last_name", service_last_name);
    }

    public void setServiceStreetName(String service_streetName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_streetName + ")");

        tool.enterStringUsingId("service_streetName", service_streetName);
    }

    public void setServiceSteetSuffix(String service_streetSuffix) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_streetSuffix + ")");
        tool.selectVisibleTextByID("service_streetSuffix", service_streetSuffix);
    }

    public void setServiceStreetNumber(String service_streetNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_streetNumber + ")");

        tool.enterStringUsingId("service_streetNumber", service_streetNumber);
    }

    public void enterServicePostCode(String service_home_zip) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_home_zip + ")");

        tool.enterStringUsingId("service_home_zip", service_home_zip);
    }

    public void enterServiceHomeCountry(String service_home_country) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_home_country + ")");
        tool.selectVisibleTextByID("service_home_country", service_home_country);
    }

    public void enterServiceHomeState(String service_home_state) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_home_state + ")");
        tool.selectVisibleTextByID("service_home_state", service_home_state);
    }

    public void enterServiceCity(String service_home_city) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + service_home_city + ")");

        tool.enterStringUsingId("service_home_city", service_home_city);
    }

    public UpdateAccountBillingAddressInformationsCommon clickEnterAdressButtonSelect() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("enter_address");
        return new UpdateAccountBillingAddressInformationsCommon(tool, test, user);
    }

    public void clickCopyFromCustomerAddressButton() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Copy from Customer Address']");
    }

    public void clickCopyFromBillingAddressButton() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Copy from Billing Address']");
    }

    public void uncheckSameAsCustomerAddress() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("link_addresschecked");
    }

    public void clickPaymentMethodCheck() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("(//input[@name='method'])[2]");
    }

    public void setBillingCompanyName(String companyName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + companyName + ")");

        tool.enterStringUsingId("company_name", companyName);
    }

    public void setBankCode(String bankcode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + bankcode + ")");

        tool.enterStringUsingId("p-L1:1-L3:1360", bankcode);
    }

    public void setBankAgencyCode(String bankagencycode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + bankagencycode + ")");

        tool.enterStringUsingId("p-L1:1-L3:1370", bankagencycode);
    }

    public void setBankAccountNumber(String bankaccountnumber) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + bankaccountnumber + ")");

        tool.enterStringUsingId("p-L1:1-L3:1380", bankaccountnumber);
    }

    public void setBankLastName(String banklastname) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + banklastname + ")");

        tool.enterStringUsingId("p-L1:1-L3:1270", banklastname);
    }

    public ShoppingCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public SearchAddressCommon clickSearchAddress() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("search_address");
        return new SearchAddressCommon(tool, test, user);
    }

    public Account enterDefaultIdentificationData() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        Account account = new Account(uniqueTimeStamp);
        Person person = new Person(uniqueTimeStamp);
        Subscriber subscriber = new Subscriber(uniqueTimeStamp);

        // Customer details
        this.setGender(person.getPersonGenderProperty());
        this.setCustomerTitle(person.getPersonTitleProperty());
        this.setCustomerFirstName(person.getPersonFirstNameProperty());
        this.setCustomerLastName(person.getPersonLastNameProperty());
        this.enterCustomerHomeCountry(person.getPersonHomeCountryProperty());
        this.enterCustomerHomeState(person.getPersonHomeStateProperty());
        this.setCustomerStreetNumber(person.getPersonStreetNumberProperty());
        this.setCustomerStreetName(person.getPersonStreetNameProperty());
        this.enterCustomerCity(person.getPersonCityProperty());
        this.enterCustomerPostCode(person.getPersonPostCodeProperty());
        this.setNationality(person.getPersonNationalityProperty());
        this.setLanguage(person.getPersonLanguageProperty());
        this.setNationalID(person.getPersonNationalIDProperty());
        this.setDateOfBirth(person.getPersonDateOfBirthProperty());
        this.setEmailAddress(person.getPersonEmailAddressProperty());
        this.setPhoneNumber(person.getPersonPhoneNumberProperty());
        this.setMobileNumber(person.getPersonMobileNumberProperty());
        this.setFaxNumber(person.getPersonFaxNumberProperty());

        // Billing Account details
        tool.clickUsingID("link_addresschecked");
        this.setBillingTitle(account.getBillingTitleProperty());
        this.setBillingFirstName(account.getBillingFirstNameProperty());
        this.setBillingLastName(account.getBillingLastNameProperty());
        this.enterBillingHomeCountry(account.getBillingHomeCountryProperty());
        this.enterBillingHomeState(account.getBillingHomeStateProperty());
        this.setBillingStreetNumber(account.getBillingStreetNumberProperty());
        this.setBillingStreetName(account.getBillingStreetNameProperty());
        this.enterBillingCity(account.getBillingCityProperty());
        this.enterBillingPostCode(account.getBillingPostCodeProperty());

        // Service Address details
        this.setServiceTitle(subscriber.getSubscriberTitleProperty());
        this.setServiceFirstName(subscriber.getSubscriberLastNameProperty());
        this.setServiceLastName(subscriber.getSubscriberFirstNameProperty());
        this.enterServiceHomeCountry(subscriber.getSubscriberHomeCountryProperty());
        this.enterServiceHomeState(subscriber.getSubscriberHomeStateProperty());
        this.setServiceStreetNumber(subscriber.getSubscriberStreetNumberProperty());
        this.setServiceStreetName(subscriber.getSubscriberStreetNameProperty());
        this.enterServiceCity(subscriber.getSubscriberCityProperty());
        this.enterServicePostCode(subscriber.getSubscriberPostCodeProperty());

        this.clickPaymentMethodCheck();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        return account;
    }

    public Account enterBusinessAccountIdentificationData() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String uniqueTimeStamp = Common.generateTimeStamp();
        Account account = new Account(uniqueTimeStamp);

        // Billing Account details
        this.setBillingCompanyName(account.getBillingCompanyNameProperty());
        this.setBusinessTitle(account.getBillingTitleProperty());
        this.setBusinessFirstName(account.getBillingFirstNameProperty());
        this.setBusinessLastName(account.getBillingLastNameProperty());
        this.enterBusinessHomeCountry(account.getBillingHomeCountryProperty());
        this.enterBusinessHomeState(account.getBillingHomeStateProperty());
        this.enterBusinessCity(account.getBillingCityProperty());
        this.enterBusinessPostCode(account.getBillingPostCodeProperty());

        this.clickPaymentMethodCheck();

        setAccount(account);

        return account;
    }

    public ClearTheCurrentBasketCommon enterCTIURL(Application application, String External_id) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + External_id + ")");
        tool.get(application.appURL() + "ctiAccess?subscriberExternalId=" + External_id + "&subscriberExternalIdType=3&ctiSessionId=123456");
        return new ClearTheCurrentBasketCommon(tool, test, user);
    }
}
