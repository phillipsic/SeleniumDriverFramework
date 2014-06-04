package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginInformationCommon extends CommonMenu {

    public LoginInformationCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Login Information";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getCurrentRoleFromPage() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContents']/div[2]/div/table/tbody/tr/td")).getText().replace(",", "");
    }

    public ChangePasswordCommon clickChangePassword() throws Exception {

        driver.findElement(By.id("youcan_CHANGE_PASSWORD")).click();
        return new ChangePasswordCommon(driver);
    }

    public ModifyLoginPasswordCommon clickChangePasswordOfAnotherUser() throws Exception {

        driver.findElement(By.id("youcan_CHANGE_PASSWORD")).click();
        return new ModifyLoginPasswordCommon(driver);
    }

    public ChangeSecretAnswerCommon clickChangeYourSecretAnswer() throws Exception {

        driver.findElement(By.id("youcan_CHANGE_SECRET_QUESTION")).click();
        return new ChangeSecretAnswerCommon(driver);
    }

    public ConfirmChangePasswordCommon clickChangePasswordOnFirstLogin() throws Exception {

        driver.findElement(By.id("youcan_CHANGE_PASSWORD_ON_FIRST_LOGIN")).click();

        return new ConfirmChangePasswordCommon(driver);
    }

    public LockLoginCommon clickLockLogin() throws Exception {

        driver.findElement(By.id("youcan_LOCK_LOGIN")).click();
        return new LockLoginCommon(driver);
    }

    public UnlockLoginCommon clickUnLockLogin() throws Exception {

        driver.findElement(By.id("youcan_UNLOCK_LOGIN")).click();
        return new UnlockLoginCommon(driver);
    }

    public DeactivateLoginCommon clickDeactivateLogin() throws Exception {

        driver.findElement(By.id("youcan_DISABLE_LOGIN")).click();
        return new DeactivateLoginCommon(driver);
    }

    public ActivateLoginCommon clickActivateLogin() throws Exception {

        driver.findElement(By.id("youcan_ENABLE_LOGIN")).click();
        return new ActivateLoginCommon(driver);
    }

    public RegisterLoginCommon clickSetLogin() throws Exception {

        driver.findElement(By.id("youcan_REGISTER_LOGIN")).click();
        return new RegisterLoginCommon(driver);
    }

    public String getTempPasswordFromPage() throws Exception {

        String password = driver.findElement(By.xpath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }

    public ChangeRolesCommon clickChangeRoles() throws Exception {

        driver.findElement(By.id("youcan_CHANGE_ROLES")).click();
        return new ChangeRolesCommon(driver);
    }

    public ChangeSecretAnswerCommon clickChangeYourSecretQuestionAndAnswer() throws Exception {

        driver.findElement(By.id("youcan_CHANGE_SECRET_QUESTION")).click();
        return new ChangeSecretAnswerCommon(driver);
    }
}
