/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

/**
 * 
 * @author iphilli
 */
public class EnterYourSubscriptionDetails extends B2CMenu {

    public Subscriber subscriber;

    public EnterYourSubscriptionDetails(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Enter your subscription details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
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

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    public void enterDateOfBirth(String dob) throws Exception {

        driver.findElement(By.id("p-CONTRACT-L4:90070")).clear();
        driver.findElement(By.id("p-CONTRACT-L4:90070")).sendKeys(dob);
    }

    public void enterLastName(String lastName) throws Exception {

        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(lastName);

    }

    public void selectTitle(String title) throws Exception {

        new Select(driver.findElement(By.id("title"))).selectByVisibleText(title);

    }

    public void selectGender(String gender) throws Exception {

        boolean correctGender = false;

        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(By.id("sex_male")).click();
            correctGender = true;
        }

        if (gender.equalsIgnoreCase("female")) {
            driver.findElement(By.id("sex_fem")).click();
            correctGender = true;
        }

        if (!correctGender) {
            throw new IllegalStateException("Gender not recognised - male or female: " + gender);

        }

    }

    public void enterstreetNumber(String streetNumber) throws Exception {

        driver.findElement(By.id("streetNumber")).clear();
        driver.findElement(By.id("streetNumber")).sendKeys(streetNumber);

    }

    public void enterHomeCity(String city) throws Exception {

        driver.findElement(By.id("home_city")).clear();
        driver.findElement(By.id("home_city")).sendKeys(city);

    }

    public void enterCounty(String county) throws Exception {

        driver.findElement(By.id("county")).clear();
        driver.findElement(By.id("county")).sendKeys(county);

    }

    public void enterPostCode(String postCode) throws Exception {

        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(postCode);

    }

    public void enterHomeCountry(String homeCountry) throws Exception {

        new Select(driver.findElement(By.id("home_country"))).selectByVisibleText(homeCountry);

    }

    public void enterHomeState(String homeState) throws Exception {

        new Select(driver.findElement(By.id("home_state"))).selectByVisibleText(homeState);

    }

    public void enterPhoneNumber(String phoneNumber) throws Exception {

        driver.findElement(By.id("phoneNumber")).clear();
        driver.findElement(By.id("phoneNumber")).sendKeys(phoneNumber);

    }

    public void enterFaxNumber(String faxNumber) throws Exception {

        driver.findElement(By.id("fax")).clear();
        driver.findElement(By.id("fax")).sendKeys(faxNumber);

    }

    public void enterEmail(String email) throws Exception {

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

    }

    public SelectOffersForYourSubscriber clickOk() throws Exception {

        driver.findElement(By.cssSelector("input.submit")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriber(driver);
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }
}
