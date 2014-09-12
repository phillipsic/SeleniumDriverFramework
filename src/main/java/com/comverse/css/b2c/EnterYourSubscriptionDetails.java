/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class EnterYourSubscriptionDetails extends B2CMenu {

    public Subscriber subscriber;

    public EnterYourSubscriptionDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Enter your subscription details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("Expecting: " + expectedScreen + " , but got: " + currentScreen);
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterDefaultIdentityAddressPhoneEmail(String uniqueString) throws Exception {
        test.writeInLog(Common.getMethodName());

        Subscriber subscriber = new Subscriber(uniqueString);

        this.enterFirstName(subscriber.getSubscriberFirstNameProperty());
        this.enterLastName(subscriber.getSubscriberLastNameProperty());
        this.selectTitle(subscriber.getSubscriberTitleProperty());
        this.selectGender(subscriber.getSubscriberGenderProperty());

        this.enterHomeCity(subscriber.getSubscriberCityProperty());
        this.enterCounty("County");
        this.enterPostCode("123456");
        this.enterHomeCountry("United States");
        this.enterHomeState("Ohio");

        this.enterPhoneNumber("01234567");
        this.enterFaxNumber("76543210");
        this.enterEmail("email@address.com");
        // this.enterDateOfBirth("12/12/1970");

        setSubscriber(subscriber);

    }

    public void enterFirstName(String firstName) throws Exception {
        test.writeInLog( Common.getMethodName() + " using data (" + firstName + ")");
        tool.enterStringUsingId("firstName", firstName);
    }

    public void enterDateOfBirth(String dob) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + dob + ")");
        tool.enterStringUsingId("p-CONTRACT-L4:90070", dob);
    }

    public void enterLastName(String lastName) throws Exception {
        test.writeInLog( Common.getMethodName() + " using data (" + lastName + ")");
        tool.enterStringUsingId("lastName", lastName);

    }

    public void selectTitle(String title) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + title + ")");
        tool.selectVisibleTextByID("title", title);

    }

    public void selectGender(String gender) throws Exception {

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

    public void enterstreetNumber(String streetNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + streetNumber + ")");
        tool.enterStringUsingId("streetNumber", streetNumber);

    }

    public void enterHomeCity(String city) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + city + ")");
        tool.enterStringUsingId("home_city", city);

    }

    public void enterCounty(String county) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + county + ")");
        tool.enterStringUsingId("county", county);

    }

    public void enterPostCode(String postCode) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + postCode + ")");
        tool.enterStringUsingId("home_zip", postCode);

    }

    public void enterHomeCountry(String homeCountry) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + homeCountry + ")");
        tool.selectVisibleTextByID("home_country", homeCountry);

    }

    public void enterHomeState(String homeState) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + homeState + ")");
        tool.selectVisibleTextByID("home_state", homeState);

    }

    public void enterPhoneNumber(String phoneNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + phoneNumber + ")");
        tool.enterStringUsingId("phoneNumber", phoneNumber);

    }

    public void enterFaxNumber(String faxNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + faxNumber + ")");
        tool.enterStringUsingId("fax", faxNumber);

    }

    public void enterEmail(String email) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + email + ")");
        tool.enterStringUsingId("email", email);

    }

    public SelectOffersForYourSubscriber clickOk() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingCssSelector("input.submit");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriber(tool, test, user);
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }
}
