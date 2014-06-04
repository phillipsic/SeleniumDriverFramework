/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginCommon {

    public final WebDriver driver;

    public LoginCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Login";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLogin(String login) throws Exception {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(login);
    }

    public void selectRole(String role) throws Exception {
        new Select(driver.findElement(By.id("roles"))).selectByVisibleText(role);
    }

    public AddMemberConfirmationCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new AddMemberConfirmationCommon(driver);
    }

    public AddMemberConfirmationCommon clickCreateLoginLater() throws Exception {
        driver.findElement(By.id("ON_OK")).click();

        return new AddMemberConfirmationCommon(driver);
    }
}
