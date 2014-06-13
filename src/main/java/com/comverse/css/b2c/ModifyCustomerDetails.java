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

public class ModifyCustomerDetails extends B2CMenu {

    public ModifyCustomerDetails(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Customer Details";

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

    public CustomerDetails clickConfirm() throws Exception {

        tool.driver.findElement(By.name("confirm_prospect")).click();

        return new CustomerDetails(tool, test, user);
    }
}
