/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class EnterYourSubscriptionDetails extends B2CMenu {

    public Subscriber subscriber;

    public EnterYourSubscriptionDetails(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Enter your subscription details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterDefaultIdentityAddressPhoneEmail(String uniqueString) throws Exception {

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

        
        tool.enterStringUsingId(tool, "firstName", firstName);
    }

    public void enterDateOfBirth(String dob) throws Exception {

        
        tool.enterStringUsingId(tool, "p-CONTRACT-L4:90070", dob);
    }

    public void enterLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId(tool, "lastName", lastName);

    }

    public void selectTitle(String title) throws Exception {

        new Select(tool.searchUsingID(tool, "title")).selectByVisibleText(title);

    }

    public void selectGender(String gender) throws Exception {

        boolean correctGender = false;

        if (gender.equalsIgnoreCase("male")) {
            tool.driver.findElement(By.id("sex_male")).click();
            correctGender = true;
        }

        if (gender.equalsIgnoreCase("female")) {
            tool.driver.findElement(By.id("sex_fem")).click();
            correctGender = true;
        }

        if (!correctGender) {
            throw new IllegalStateException("Gender not recognised - male or female: " + gender);

        }

    }

    public void enterstreetNumber(String streetNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "streetNumber", streetNumber);

    }

    public void enterHomeCity(String city) throws Exception {

        
        tool.enterStringUsingId(tool, "home_city", city);

    }

    public void enterCounty(String county) throws Exception {

        
        tool.enterStringUsingId(tool, "county", county);

    }

    public void enterPostCode(String postCode) throws Exception {

        
        tool.enterStringUsingId(tool, "home_zip", postCode);

    }

    public void enterHomeCountry(String homeCountry) throws Exception {

        new Select(tool.searchUsingID(tool, "home_country")).selectByVisibleText(homeCountry);

    }

    public void enterHomeState(String homeState) throws Exception {

        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(homeState);

    }

    public void enterPhoneNumber(String phoneNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "phoneNumber", phoneNumber);

    }

    public void enterFaxNumber(String faxNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "fax", faxNumber);

    }

    public void enterEmail(String email) throws Exception {

        
        tool.enterStringUsingId(tool, "email", email);

    }

    public SelectOffersForYourSubscriber clickOk() throws Exception {

        tool.clickUsingCssSelector(tool, "input.submit");
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
