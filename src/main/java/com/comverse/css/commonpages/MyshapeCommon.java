package com.comverse.css.commonpages;

import java.util.MissingResourceException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.Application;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class MyshapeCommon extends CommonMenu {

    public MyshapeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    public void successfulLogin(User user) throws Exception {

        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property Login " + user.getLogin(), PASSWORD_PROPERTY_FILE, user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property Password " + user.getPassword(), PASSWORD_PROPERTY_FILE, user.getPassword());
        }

        this.setUserName(user.getLogin());
        this.setPassword(user.getPassword());
        if (user.getRealm() != null)
            this.selectRealm(user.getRealm());
        this.clickLogin();

        if (tool.driver.getPageSource().contains("Please enter a valid user name and password.")) {
            throw new Exception("Invalid username or password - IS USER CREATED? ");
        }

        if (tool.driver.getPageSource().contains("Synchronization Failed")) {
            throw new Exception("Synchronization Failed - ENVIRONMENT PROBLEM?");
        }

    }

    public void setYourPassword(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password_old", password);
    }

    public void setNewPassword(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password_new", password);
    }

    public void setConfirmNewPassword(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password_verify", password);
    }

    public void setSecretAnswer(String secretAnswer) throws Exception {
        
        tool.enterStringUsingId(tool, "secretAnswer", secretAnswer);
    }

    public void clickOk() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
    }

    public void clickSubmit() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Submit']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void clickHomePage() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Home Page']");
    }

    public void clickAdminLogin(Application application) throws Exception {
        tool.driver.get(application.appURL() + "/jfn?entry=admin_login");
    }

    public void clickForgotYourPassword() throws Exception {
        tool.clickUsingID(tool, "lnk_FORGOTTEN_PASSWORD");
    }

    public void setUserName(String login) throws Exception {
        
        tool.enterStringUsingId(tool, "login", login);
    }

    public void setPassword(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password", password);
    }

    public void selectRealm(String realm) throws Exception {
        if (tool.driver.getPageSource().contains("Domain")) {
            new Select(tool.searchUsingID(tool, "realm")).selectByVisibleText(realm);
        }
    }

    public void clickLogin() throws Exception {
        tool.clickUsingName(tool, "LoginButton");
    }

    public String getMessage() throws Exception {
        return tool.driver.findElement(By.xpath("//span")).getText();
    }

    public MyshapeCommon unsuccessfulLogin(User user) throws Exception {
        this.setUserName(user.getLogin());
        this.setPassword(user.getPassword());
        this.clickLogin();

        return new MyshapeCommon(tool, test, user);
    }

    public String getTempPasswordFromPage() throws Exception {
        String password = tool.driver.findElement(By.xpath("//span")).getText();
        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());

        return password.trim();
    }

    public WorkSpaceCommon clickContinue() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue']");

        return new WorkSpaceCommon(tool, test, user);
    }

    public String getChangePasswordOnFirstLoginMessage() throws Exception {
        System.out.println(">>" + tool.driver.findElement(By.cssSelector("span")).getText());

        return tool.driver.findElement(By.cssSelector("span")).getText();
    }
}
