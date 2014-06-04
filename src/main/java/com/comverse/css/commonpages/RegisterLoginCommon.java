/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author iphilli
 */
public class RegisterLoginCommon extends CommonMenu {

    public RegisterLoginCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle().toLowerCase();
        String expectedScreen = "Register login".toLowerCase();

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

    public RegisterLoginCommon clickRegisterLoginContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new RegisterLoginCommon(driver);
    }

    public void clickRadioButtonTelcoCSRUser() throws Exception {

        driver.findElement(By.xpath("(//input[@name='roles'])[9]")).click();

    }

    public void clickRadioButtonOCMUser() throws Exception {

        driver.findElement(By.xpath("//input[@name='roles']")).click();

    }

    public String getTempPasswordFromPage() throws Exception {

        String password = driver.findElement(By.xpath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();

    }

    public ViewHierarchyCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(driver);
    }

}
