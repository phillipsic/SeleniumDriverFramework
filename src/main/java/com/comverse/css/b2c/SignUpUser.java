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

public class SignUpUser extends B2CMenu {

    public SignUpUser(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Sign Up User";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAddressLineOne(String addressLine1) throws Exception {

        tool.driver.findElement(By.id("address_line_1")).clear();
        tool.driver.findElement(By.id("address_line_1")).sendKeys(addressLine1);

    }

    public void enterAddressLineTwo(String addressLine2) throws Exception {

        tool.driver.findElement(By.id("address_line_2")).clear();
        tool.driver.findElement(By.id("address_line_2")).sendKeys(addressLine2);

    }

    public void enterAddressLineThree(String addressLine3) throws Exception {

        tool.driver.findElement(By.id("address_line_3")).clear();
        tool.driver.findElement(By.id("address_line_3")).sendKeys(addressLine3);

    }

    public void enterAddressLineFour(String addressLine4) throws Exception {

        tool.driver.findElement(By.id("address_line_4")).clear();
        tool.driver.findElement(By.id("address_line_4")).sendKeys(addressLine4);

    }

    public void enterZipCode(String zipCode) throws Exception {

        tool.driver.findElement(By.id("zip")).clear();
        tool.driver.findElement(By.id("zip")).sendKeys(zipCode);

    }

    public void enterCity(String city) throws Exception {

        tool.driver.findElement(By.id("city")).clear();
        tool.driver.findElement(By.id("city")).sendKeys(city);

    }

    public void selectState(String state) throws Exception {

        new Select(tool.searchUsingName(tool, "state")).selectByVisibleText(state);

    }

    public void enterFirstName(String firstName) throws Exception {

        tool.driver.findElement(By.id("first_name")).clear();
        tool.driver.findElement(By.id("first_name")).sendKeys(firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("last_name")).clear();
        tool.driver.findElement(By.id("last_name")).sendKeys(lastName);

    }

    public void enterEmailAddress(String emailAddress) throws Exception {

        tool.driver.findElement(By.id("company_email")).clear();
        tool.driver.findElement(By.id("company_email")).sendKeys(emailAddress);

    }

    public void enterLogin(String uniqueTimeStamp) throws Exception {

        tool.driver.findElement(By.id("login")).clear();
        tool.driver.findElement(By.id("login")).sendKeys(uniqueTimeStamp);
        System.out.println("Login - " + uniqueTimeStamp);

    }

    public void enterPassword(String password) throws Exception {

        tool.driver.findElement(By.id("password")).clear();
        tool.driver.findElement(By.id("password")).sendKeys(password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        tool.driver.findElement(By.id("confirm_password")).clear();
        tool.driver.findElement(By.id("confirm_password")).sendKeys(confirmPassword);

    }

    public void selectSecretQuestion(String secretQuestion) throws Exception {

        new Select(tool.searchUsingName(tool, "secret_question")).selectByVisibleText(secretQuestion);

    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {

        tool.driver.findElement(By.id("secret_answer")).clear();
        tool.driver.findElement(By.id("secret_answer")).sendKeys(secretAnswer);
    }

    public void enterNationalId(String national_id) throws Exception {

        tool.driver.findElement(By.id("national_id")).clear();
        tool.driver.findElement(By.id("national_id")).sendKeys(national_id);
    }

    public void enterDateOfBirth(String dob) throws Exception {

        tool.driver.findElement(By.id("date_of_birth")).clear();
        tool.driver.findElement(By.id("date_of_birth")).sendKeys(dob);
    }

    public CustomerDetails clickSignMeUp() throws Exception {

        tool.driver.findElement(By.name("signmeup")).click();
        return new CustomerDetails(tool, test, user);
    }

    public CustomerDetails enterMandatoryFieldsOnlyAndClickSignMeUp(String uniqueTimeStamp) throws Exception {

        this.enterFirstName("FN" + uniqueTimeStamp);
        this.enterLastName("LN" + uniqueTimeStamp);
        this.enterAddressLineOne("Address Line One");
        this.enterZipCode("12345");
        this.enterCity("City1");
        this.selectState("Alabama");
        this.enterEmailAddress("email@comverse.com");
        this.enterLogin(uniqueTimeStamp);
        this.enterPassword("0123456");
        this.enterConfirmPassword("0123456");
        this.selectSecretQuestion("When did you kiss for the first time?");
        this.enterSecretAnswer("20 Nov 2012");
        this.enterDateOfBirth("12/12/1975");
        this.enterNationalId(uniqueTimeStamp);
        return this.clickSignMeUp();
    }

    public void uncheckSameAsCustomerAddress() throws Exception {

        tool.driver.findElement(By.id("linkAddress")).click();

    }

    public void enterBillingAddressLineOne(String addressLine1) throws Exception {

        tool.driver.findElement(By.id("billingAddressLine1")).clear();
        tool.driver.findElement(By.id("billingAddressLine1")).sendKeys(addressLine1);

    }

    public void enterBillingAddressLineTwo(String addressLine2) throws Exception {

        tool.driver.findElement(By.id("billingAddressLine2")).clear();
        tool.driver.findElement(By.id("billingAddressLine2")).sendKeys(addressLine2);

    }

    public void enterBillingAddressLineThree(String addressLine3) throws Exception {

        tool.driver.findElement(By.id("billingAddressLine3")).clear();
        tool.driver.findElement(By.id("billingAddressLine3")).sendKeys(addressLine3);

    }

    public void enterBillingAddressLineFour(String addressLine4) throws Exception {

        tool.driver.findElement(By.id("billingAddressLine4")).clear();
        tool.driver.findElement(By.id("billingAddressLine4")).sendKeys(addressLine4);

    }

    public void enterBillingZipCode(String zipCode) throws Exception {

        tool.driver.findElement(By.id("billingZip")).clear();
        tool.driver.findElement(By.id("billingZip")).sendKeys(zipCode);

    }

    public void enterBillingCity(String city) throws Exception {

        tool.driver.findElement(By.id("billingCity")).clear();
        tool.driver.findElement(By.id("billingCity")).sendKeys(city);

    }

    public void selectBillingState(String state) throws Exception {

        new Select(tool.searchUsingName(tool, "billingState")).selectByVisibleText(state);

    }

    public void selectBillingTitle(String title) throws Exception {

        new Select(tool.searchUsingID(tool, "billingTitle")).selectByVisibleText(title);

    }

    public void enterBillingFirstName(String firstName) throws Exception {

        tool.driver.findElement(By.id("billingFirstName")).clear();
        tool.driver.findElement(By.id("billingFirstName")).sendKeys(firstName);

    }

    public void enterBillingLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("billingLastName")).clear();
        tool.driver.findElement(By.id("billingLastName")).sendKeys(lastName);

    }
}
