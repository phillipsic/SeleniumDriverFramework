/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RegisterNewResidentialMember extends B2CMenu {

    public RegisterNewResidentialMember(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Register New Residential Member";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public void enterFirstName(String firstName) throws Exception {

        tool.driver.findElement(By.id("firstname")).clear();
        tool.driver.findElement(By.id("firstname")).sendKeys(firstName);
        System.out.println("Login - " + firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("lastname")).clear();
        tool.driver.findElement(By.id("lastname")).sendKeys(lastName);
        System.out.println("Password - " + lastName);

    }

    public void enterLogin(String login) throws Exception {

        tool.driver.findElement(By.id("login")).clear();
        tool.driver.findElement(By.id("login")).sendKeys(login);
        System.out.println("Login - " + login);

    }

    public void enterPassword(String password) throws Exception {

        tool.driver.findElement(By.id("password")).clear();
        tool.driver.findElement(By.id("password")).sendKeys(password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        tool.driver.findElement(By.id("confirmPassword")).clear();
        tool.driver.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);

    }

    public void clickSubmit() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Submit']")).click();
    }

    public RequestSubmission clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new RequestSubmission(tool, test, user);
    }

    public void clickResidentialSubscriber() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@name='role'])[2]")).click();
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
        return new RequestSubmission(tool, test, user);
    }
}
