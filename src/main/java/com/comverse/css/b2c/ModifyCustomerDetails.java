/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyCustomerDetails extends B2CMenu {

    public ModifyCustomerDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Customer Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAddressLineOne(String addressLine1) throws Exception {

        tool.enterStringUsingId("address_line_1", addressLine1);

    }

    public void enterAddressLineTwo(String addressLine2) throws Exception {

        tool.enterStringUsingId("address_line_2", addressLine2);

    }

    public void enterAddressLineThree(String addressLine3) throws Exception {

        tool.enterStringUsingId("address_line_3", addressLine3);

    }

    public void enterAddressLineFour(String addressLine4) throws Exception {

        tool.enterStringUsingId("address_line_4", addressLine4);

    }

    public void enterZipCode(String zipCode) throws Exception {

        tool.enterStringUsingId("zip", zipCode);

    }

    public void enterCity(String city) throws Exception {

        tool.enterStringUsingId("city", city);

    }

    public void selectState(String state) throws Exception {

        tool.selectVisibleTextByName("state", state);

    }

    public void enterFirstName(String firstName) throws Exception {

        tool.enterStringUsingId("first_name", firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        tool.enterStringUsingId("last_name", lastName);

    }

    public void enterEmailAddress(String emailAddress) throws Exception {

        tool.enterStringUsingId("company_email", emailAddress);

    }

    public void enterLogin(String uniqueTimeStamp) throws Exception {

        tool.enterStringUsingId("login", uniqueTimeStamp);
        System.out.println("Login - " + uniqueTimeStamp);

    }

    public void enterPassword(String password) throws Exception {

        tool.enterStringUsingId("password", password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        tool.enterStringUsingId("confirm_password", confirmPassword);

    }

    public void selectSecretQuestion(String secretQuestion) throws Exception {

        tool.selectVisibleTextByName("secret_question", secretQuestion);

    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {

        tool.enterStringUsingId("secret_answer", secretAnswer);
    }

    public void enterNationalId(String national_id) throws Exception {

        tool.enterStringUsingId("national_id", national_id);
    }

    public void enterDateOfBirth(String dob) throws Exception {

        tool.enterStringUsingId("date_of_birth", dob);
    }

    public CustomerDetails clickConfirm() throws Exception {

        tool.clickUsingName("confirm_prospect");

        return new CustomerDetails(tool, test, user);
    }
}
