/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.commonpages.LoginCommon;

public class Login extends LoginCommon {

    public Login(WebDriver driver) {
        super(driver);
    }

    @Override
    public AddMemberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new AddMemberConfirmation(driver);
    }

    @Override
    public AddMemberConfirmation clickCreateLoginLater() throws Exception {
        super.clickCreateLoginLater();
        return new AddMemberConfirmation(driver);
    }

    public void enterLogin(String login) throws Exception {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(login);
    }

    public RegisterLogin clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new RegisterLogin(driver);
    }

    public AddMemberConfirmation clickSubmit() throws Exception {
        driver.findElement(By.cssSelector("input.submit")).click();
        return new AddMemberConfirmation(driver);
    }

    public void setRoles(String roles) throws Exception {
        new Select(driver.findElement(By.id("roles"))).selectByVisibleText(roles);
    }
}
