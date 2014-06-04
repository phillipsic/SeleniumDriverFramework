/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class RegisterNewResidentialMember extends B2CMenu {

    public RegisterNewResidentialMember(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Register New Residential Member";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public void enterFirstName(String firstName) throws Exception {

        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        System.out.println("Login - " + firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        System.out.println("Password - " + lastName);

    }

    public void enterLogin(String login) throws Exception {

        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(login);
        System.out.println("Login - " + login);

    }

    public void enterPassword(String password) throws Exception {

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);

    }

    public void clickSubmit() throws Exception {

        driver.findElement(By.xpath("//input[@value='Submit']")).click();
    }

    public RequestSubmission clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new RequestSubmission(driver);
    }

    public void clickResidentialSubscriber() throws Exception {

        driver.findElement(By.xpath("(//input[@name='role'])[2]")).click();
    }

    public RequestSubmission createResidentialSubscriber(String uniqueString, String password) throws Exception {

        this.enterFirstName("FN" + uniqueString);
        this.enterLastName("LN" + uniqueString);
        this.enterLogin(uniqueString);
        this.enterPassword(password);
        this.enterConfirmPassword(password);
        this.clickResidentialSubscriber();
        this.clickSubmit();
        this.clickConfirm();
        return new RequestSubmission(driver);
    }
}
