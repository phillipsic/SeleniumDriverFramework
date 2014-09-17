/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SignUpUser extends B2CMenu {

    public SignUpUser(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Sign Up User";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterAddressLineOne(String addressLine1) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine1 + ")");
        tool.enterStringUsingId("address_line_1", addressLine1);

    }

    public void enterAddressLineTwo(String addressLine2) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine2 + ")");
        tool.enterStringUsingId("address_line_2", addressLine2);

    }

    public void enterAddressLineThree(String addressLine3) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine3 + ")");
        tool.enterStringUsingId("address_line_3", addressLine3);

    }

    public void enterAddressLineFour(String addressLine4) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine4 + ")");
        tool.enterStringUsingId("address_line_4", addressLine4);

    }

    public void enterZipCode(String zipCode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + zipCode + ")");
        tool.enterStringUsingId("zip", zipCode);

    }

    public void enterCity(String city) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + city + ")");
        tool.enterStringUsingId("city", city);

    }

    public void selectState(String state) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + state + ")");
        tool.selectVisibleTextByName("state", state);

    }

    public void enterFirstName(String firstName) throws Exception {

        test.writeInLogFile(Common.getMethodName() + " using data (" + firstName + ")");
        tool.enterStringUsingId("first_name", firstName);

    }

    public void enterLastName(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + lastName + ")");
        tool.enterStringUsingId("last_name", lastName);

    }

    public void enterEmailAddress(String emailAddress) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + emailAddress + ")");
        tool.enterStringUsingId("company_email", emailAddress);

    }

    public void enterLogin(String uniqueTimeStamp) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + uniqueTimeStamp + ")");
        tool.enterStringUsingId("login", uniqueTimeStamp);
        System.out.println("Login - " + uniqueTimeStamp);

    }

    public void enterPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + password + ")");
        tool.enterStringUsingId("password", password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + confirmPassword + ")");
        tool.enterStringUsingId("confirm_password", confirmPassword);

    }

    public void selectSecretQuestion(String secretQuestion) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + secretQuestion + ")");
        tool.selectVisibleTextByName("secret_question", secretQuestion);

    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + secretAnswer + ")");
        tool.enterStringUsingId("secret_answer", secretAnswer);
    }

    public void enterNationalId(String national_id) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + national_id + ")");
        tool.enterStringUsingId("national_id", national_id);
    }

    public void enterDateOfBirth(String dob) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + dob + ")");
        tool.enterStringUsingId("date_of_birth", dob);
    }

    public CustomerDetails clickSignMeUp() throws Exception {
        test.writeInLogFile(Common.getMethodName() );
        tool.clickUsingName("signmeup");
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
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("linkAddress");

    }

    public void enterBillingAddressLineOne(String addressLine1) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine1 + ")");
        tool.enterStringUsingId("billingAddressLine1", addressLine1);

    }

    public void enterBillingAddressLineTwo(String addressLine2) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine2 + ")");
        tool.enterStringUsingId("billingAddressLine2", addressLine2);

    }

    public void enterBillingAddressLineThree(String addressLine3) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine3 + ")");
        tool.enterStringUsingId("billingAddressLine3", addressLine3);

    }

    public void enterBillingAddressLineFour(String addressLine4) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine4 + ")");
        tool.enterStringUsingId("billingAddressLine4", addressLine4);

    }

    public void enterBillingZipCode(String zipCode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + zipCode + ")");
        tool.enterStringUsingId("billingZip", zipCode);

    }

    public void enterBillingCity(String city) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + city + ")");
        tool.enterStringUsingId("billingCity", city);

    }

    public void selectBillingState(String state) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + state + ")");
        tool.selectVisibleTextByName("billingState", state);

    }

    public void selectBillingTitle(String title) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + title + ")");
        tool.selectVisibleTextByID("billingTitle", title);

    }

    public void enterBillingFirstName(String firstName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + firstName + ")");
        tool.enterStringUsingId("billingFirstName", firstName);

    }

    public void enterBillingLastName(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + lastName + ")");
        tool.enterStringUsingId("billingLastName", lastName);

    }
}
