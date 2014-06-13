package com.comverse.sec;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class SecCsrAdmin extends CommonMenu {

    public SecCsrAdmin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Security | Add User";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setFirstName(String firstName) throws Exception {

        tool.driver.findElement(By.id("j_id44:j_id45:0:firstNameField:j_id97")).clear();
        tool.driver.findElement(By.id("j_id44:j_id45:0:firstNameField:j_id97")).sendKeys(firstName);
    }

    public void setLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("j_id44:j_id45:0:lastNameField:j_id119")).clear();
        tool.driver.findElement(By.id("j_id44:j_id45:0:lastNameField:j_id119")).sendKeys(lastName);
    }

    public void setUserName(String userName) throws Exception {

        tool.driver.findElement(By.id("j_id44:j_id45:0:userNameField:j_id59")).clear();
        tool.driver.findElement(By.id("j_id44:j_id45:0:userNameField:j_id59")).sendKeys(userName);
    }

    public void setPassword(String password) throws Exception {

        tool.driver.findElement(By.id("j_id44:j_id45:0:passwordField:j_id75")).clear();
        tool.driver.findElement(By.id("j_id44:j_id45:0:passwordField:j_id75")).sendKeys(password);
    }

    public void setRePassword(String repassword) throws Exception {

        tool.driver.findElement(By.id("j_id44:j_id45:0:re-passwordField:j_id86")).clear();
        tool.driver.findElement(By.id("j_id44:j_id45:0:re-passwordField:j_id86")).sendKeys(repassword);
    }

    public void setEmail(String email) throws Exception {

        tool.driver.findElement(By.id("j_id44:j_id45:0:emailField:j_id163")).clear();
        tool.driver.findElement(By.id("j_id44:j_id45:0:emailField:j_id163")).sendKeys(email);
    }

    public void setGroups(String Group) throws Exception {

        new Select(tool.searchUsingID(tool, "j_id44:j_id45:0:tempGroupsUpdate:j_id245")).selectByVisibleText(Group);
        tool.driver.findElement(By.id("j_id44:j_id45:0:tempGroupsUpdate:j_id247")).click();

    }

    public void clickSave() throws Exception {

        tool.driver.findElement(By.id("j_id44:j_id45:0:save")).click();

    }

}
