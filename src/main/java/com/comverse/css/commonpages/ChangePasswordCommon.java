package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordCommon extends CommonMenu {

    public ChangePasswordCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Change Password";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setYourPassword(String password) throws Exception {

        driver.findElement(By.id("oldPassword")).clear();
        driver.findElement(By.id("oldPassword")).sendKeys(password);
    }

    public void setNewPassword(String password) throws Exception {

        driver.findElement(By.id("newPassword")).clear();
        driver.findElement(By.id("newPassword")).sendKeys(password);
    }

    public void setConfirmNewPassword(String password) throws Exception {

        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys(password);
    }

    public ModifyLoginPasswordCommon clickChange() throws Exception {

        driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new ModifyLoginPasswordCommon(driver);
    }
}
