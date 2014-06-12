package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class LoginInformationCommon extends CommonMenu {

    public LoginInformationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Login Information";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getCurrentRoleFromPage() throws Exception {

        return tool.driver.findElement(By.xpath("//div[@id='mainContents']/div[2]/div/table/tbody/tr/td")).getText().replace(",", "");
    }

    public ChangePasswordCommon clickChangePassword() throws Exception {

        tool.driver.findElement(By.id("youcan_CHANGE_PASSWORD")).click();
        return new ChangePasswordCommon(tool, test, user);
    }

    public ModifyLoginPasswordCommon clickChangePasswordOfAnotherUser() throws Exception {

        tool.driver.findElement(By.id("youcan_CHANGE_PASSWORD")).click();
        return new ModifyLoginPasswordCommon(tool, test, user);
    }

    public ChangeSecretAnswerCommon clickChangeYourSecretAnswer() throws Exception {

        tool.driver.findElement(By.id("youcan_CHANGE_SECRET_QUESTION")).click();
        return new ChangeSecretAnswerCommon(tool, test, user);
    }

    public ConfirmChangePasswordCommon clickChangePasswordOnFirstLogin() throws Exception {

        tool.driver.findElement(By.id("youcan_CHANGE_PASSWORD_ON_FIRST_LOGIN")).click();

        return new ConfirmChangePasswordCommon(tool, test, user);
    }

    public LockLoginCommon clickLockLogin() throws Exception {

        tool.driver.findElement(By.id("youcan_LOCK_LOGIN")).click();
        return new LockLoginCommon(tool, test, user);
    }

    public UnlockLoginCommon clickUnLockLogin() throws Exception {

        tool.driver.findElement(By.id("youcan_UNLOCK_LOGIN")).click();
        return new UnlockLoginCommon(tool, test, user);
    }

    public DeactivateLoginCommon clickDeactivateLogin() throws Exception {

        tool.driver.findElement(By.id("youcan_DISABLE_LOGIN")).click();
        return new DeactivateLoginCommon(tool, test, user);
    }

    public ActivateLoginCommon clickActivateLogin() throws Exception {

        tool.driver.findElement(By.id("youcan_ENABLE_LOGIN")).click();
        return new ActivateLoginCommon(tool, test, user);
    }

    public RegisterLoginCommon clickSetLogin() throws Exception {

        tool.driver.findElement(By.id("youcan_REGISTER_LOGIN")).click();
        return new RegisterLoginCommon(tool, test, user);
    }

    public String getTempPasswordFromPage() throws Exception {

        String password = tool.driver.findElement(By.xpath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }

    public ChangeRolesCommon clickChangeRoles() throws Exception {

        tool.driver.findElement(By.id("youcan_CHANGE_ROLES")).click();
        return new ChangeRolesCommon(tool, test, user);
    }

    public ChangeSecretAnswerCommon clickChangeYourSecretQuestionAndAnswer() throws Exception {

        tool.driver.findElement(By.id("youcan_CHANGE_SECRET_QUESTION")).click();
        return new ChangeSecretAnswerCommon(tool, test, user);
    }
}
