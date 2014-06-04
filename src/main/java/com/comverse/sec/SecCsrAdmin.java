/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.sec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


/**
 *
 * @author cchadai
 */
public class SecCsrAdmin {
    
    private final WebDriver driver;
    
    public SecCsrAdmin(WebDriver driver) {

        this.driver = driver;

        String currentScreen = driver.getTitle();
        String expectedScreen = "Security | Add User";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setFirstName(String firstName) throws Exception {

        driver.findElement(By.id("j_id44:j_id45:0:firstNameField:j_id97")).clear();
        driver.findElement(By.id("j_id44:j_id45:0:firstNameField:j_id97")).sendKeys(firstName);
    }

    public void setLastName(String lastName) throws Exception {

        driver.findElement(By.id("j_id44:j_id45:0:lastNameField:j_id119")).clear();
        driver.findElement(By.id("j_id44:j_id45:0:lastNameField:j_id119")).sendKeys(lastName);
    }

    public void setUserName(String userName) throws Exception {

        driver.findElement(By.id("j_id44:j_id45:0:userNameField:j_id59")).clear();
        driver.findElement(By.id("j_id44:j_id45:0:userNameField:j_id59")).sendKeys(userName);
    }

    public void setPassword(String password) throws Exception {

        driver.findElement(By.id("j_id44:j_id45:0:passwordField:j_id75")).clear();
        driver.findElement(By.id("j_id44:j_id45:0:passwordField:j_id75")).sendKeys(password);
    }

    public void setRePassword(String repassword) throws Exception {

        driver.findElement(By.id("j_id44:j_id45:0:re-passwordField:j_id86")).clear();
        driver.findElement(By.id("j_id44:j_id45:0:re-passwordField:j_id86")).sendKeys(repassword);
    }

    public void setEmail(String email) throws Exception {

        driver.findElement(By.id("j_id44:j_id45:0:emailField:j_id163")).clear();
        driver.findElement(By.id("j_id44:j_id45:0:emailField:j_id163")).sendKeys(email);
    }

    public void setGroups(String Group) throws Exception {

       new Select(driver.findElement(By.id("j_id44:j_id45:0:tempGroupsUpdate:j_id245"))).selectByVisibleText(Group);
       driver.findElement(By.id("j_id44:j_id45:0:tempGroupsUpdate:j_id247")).click();

    }

   public void clickSave() throws Exception {

       driver.findElement(By.id("j_id44:j_id45:0:save")).click();

    }

}
