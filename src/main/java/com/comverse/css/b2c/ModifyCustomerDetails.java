/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author iphilli
 */
public class ModifyCustomerDetails extends B2CMenu {

    public ModifyCustomerDetails(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Customer Details";


        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAddressLineOne(String addressLine1) throws Exception {

        driver.findElement(By.id("address_line_1")).clear();
        driver.findElement(By.id("address_line_1")).sendKeys(addressLine1);

    }

    public void enterAddressLineTwo(String addressLine2) throws Exception {

        driver.findElement(By.id("address_line_2")).clear();
        driver.findElement(By.id("address_line_2")).sendKeys(addressLine2);

    }

    public void enterAddressLineThree(String addressLine3) throws Exception {

        driver.findElement(By.id("address_line_3")).clear();
        driver.findElement(By.id("address_line_3")).sendKeys(addressLine3);

    }

    public void enterAddressLineFour(String addressLine4) throws Exception {

        driver.findElement(By.id("address_line_4")).clear();
        driver.findElement(By.id("address_line_4")).sendKeys(addressLine4);

    }

    public void enterZipCode(String zipCode) throws Exception {

        driver.findElement(By.id("zip")).clear();
        driver.findElement(By.id("zip")).sendKeys(zipCode);

    }

    public void enterCity(String city) throws Exception {

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);

    }

    public void selectState(String state) throws Exception {

        new Select(driver.findElement(By.name("state"))).selectByVisibleText(state);

    }

    public void enterFirstName(String firstName) throws Exception {

        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys(firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys(lastName);

    }

    public void enterEmailAddress(String emailAddress) throws Exception {

        driver.findElement(By.id("company_email")).clear();
        driver.findElement(By.id("company_email")).sendKeys(emailAddress);

    }

    public void enterLogin(String uniqueTimeStamp) throws Exception {

        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(uniqueTimeStamp);
        System.out.println("Login - " + uniqueTimeStamp);

    }

    public void enterPassword(String password) throws Exception {

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        driver.findElement(By.id("confirm_password")).clear();
        driver.findElement(By.id("confirm_password")).sendKeys(confirmPassword);

    }

    public void selectSecretQuestion(String secretQuestion) throws Exception {

        new Select(driver.findElement(By.name("secret_question"))).selectByVisibleText(secretQuestion);

    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {

        driver.findElement(By.id("secret_answer")).clear();
        driver.findElement(By.id("secret_answer")).sendKeys(secretAnswer);
    }

    public void enterNationalId(String national_id) throws Exception {

        driver.findElement(By.id("national_id")).clear();
        driver.findElement(By.id("national_id")).sendKeys(national_id);
    }

    public void enterDateOfBirth(String dob) throws Exception {

        driver.findElement(By.id("date_of_birth")).clear();
        driver.findElement(By.id("date_of_birth")).sendKeys(dob);
    }

    public CustomerDetails clickConfirm() throws Exception {

        driver.findElement(By.name("confirm_prospect")).click();

        return new CustomerDetails(driver);
    }
}
