/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyCustomerDetails extends B2CMenu {

    public ModifyCustomerDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Modify Customer Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAddressLineOne(String addressLine1) throws Exception {

        
        tool.enterStringUsingId(tool, "address_line_1", addressLine1);

    }

    public void enterAddressLineTwo(String addressLine2) throws Exception {

        
        tool.enterStringUsingId(tool, "address_line_2", addressLine2);

    }

    public void enterAddressLineThree(String addressLine3) throws Exception {

        
        tool.enterStringUsingId(tool, "address_line_3", addressLine3);

    }

    public void enterAddressLineFour(String addressLine4) throws Exception {

        
        tool.enterStringUsingId(tool, "address_line_4", addressLine4);

    }

    public void enterZipCode(String zipCode) throws Exception {

        
        tool.enterStringUsingId(tool, "zip", zipCode);

    }

    public void enterCity(String city) throws Exception {

        
        tool.enterStringUsingId(tool, "city", city);

    }

    public void selectState(String state) throws Exception {

        new Select(tool.searchUsingName(tool, "state")).selectByVisibleText(state);

    }

    public void enterFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId(tool, "first_name", firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId(tool, "last_name", lastName);

    }

    public void enterEmailAddress(String emailAddress) throws Exception {

        
        tool.enterStringUsingId(tool, "company_email", emailAddress);

    }

    public void enterLogin(String uniqueTimeStamp) throws Exception {

        
        tool.enterStringUsingId(tool, "login", uniqueTimeStamp);
        System.out.println("Login - " + uniqueTimeStamp);

    }

    public void enterPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "password", password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        
        tool.enterStringUsingId(tool, "confirm_password", confirmPassword);

    }

    public void selectSecretQuestion(String secretQuestion) throws Exception {

        new Select(tool.searchUsingName(tool, "secret_question")).selectByVisibleText(secretQuestion);

    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {

        
        tool.enterStringUsingId(tool, "secret_answer", secretAnswer);
    }

    public void enterNationalId(String national_id) throws Exception {

        
        tool.enterStringUsingId(tool, "national_id", national_id);
    }

    public void enterDateOfBirth(String dob) throws Exception {

        
        tool.enterStringUsingId(tool, "date_of_birth", dob);
    }

    public CustomerDetails clickConfirm() throws Exception {

        tool.clickUsingName(tool, "confirm_prospect");

        return new CustomerDetails(tool, test, user);
    }
}
