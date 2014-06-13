/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RegisterLoginCommon extends CommonMenu {

    public RegisterLoginCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle().toLowerCase();
        String expectedScreen = "Register login".toLowerCase();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLogin(String login) throws Exception {

        
        tool.enterStringUsingId(tool, "login", login);
    }

    public void selectRole(String role) throws Exception {

        new Select(tool.searchUsingID(tool, "roles")).selectByVisibleText(role);
    }

    public AddMemberConfirmationCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new AddMemberConfirmationCommon(tool, test, user);
    }

    public RegisterLoginCommon clickRegisterLoginContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new RegisterLoginCommon(tool, test, user);
    }

    public void clickRadioButtonTelcoCSRUser() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@name='roles'])[9]")).click();

    }

    public void clickRadioButtonOCMUser() throws Exception {

        tool.driver.findElement(By.xpath("//input[@name='roles']")).click();

    }

    public String getTempPasswordFromPage() throws Exception {

        String password = tool.driver.findElement(By.xpath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();

    }

    public ViewHierarchyCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(tool, test, user);
    }

}
