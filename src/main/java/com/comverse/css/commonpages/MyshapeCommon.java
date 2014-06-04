package com.comverse.css.commonpages;

import java.util.MissingResourceException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.Application;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class MyshapeCommon extends CommonMenu {

    public MyshapeCommon(WebDriver driver) throws Exception {
        super(driver);
    }

    public void successfulLogin(User user) throws Exception {

        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getLogin(), PASSWORD_PROPERTY_FILE, user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getPassword(), PASSWORD_PROPERTY_FILE, user.getPassword());
        }

        this.setUserName(user.getLogin());
        this.setPassword(user.getPassword());
        if (user.getRealm() != null)
            this.selectRealm(user.getRealm());
        this.clickLogin();

        if (driver.getPageSource().contains("Please enter a valid user name and password.")) {
            throw new Exception("Invalid username or password - IS USER CREATED? ");
        }

        if (driver.getPageSource().contains("Synchronization Failed")) {
            throw new Exception("Synchronization Failed - ENVIRONMENT PROBLEM?");
        }

    }

    public void setYourPassword(String password) throws Exception {
        driver.findElement(By.id("password_old")).clear();
        driver.findElement(By.id("password_old")).sendKeys(password);
    }

    public void setNewPassword(String password) throws Exception {
        driver.findElement(By.id("password_new")).clear();
        driver.findElement(By.id("password_new")).sendKeys(password);
    }

    public void setConfirmNewPassword(String password) throws Exception {
        driver.findElement(By.id("password_verify")).clear();
        driver.findElement(By.id("password_verify")).sendKeys(password);
    }

    public void setSecretAnswer(String secretAnswer) throws Exception {
        driver.findElement(By.id("secretAnswer")).clear();
        driver.findElement(By.id("secretAnswer")).sendKeys(secretAnswer);
    }

    public void clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void clickSubmit() throws Exception {
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public void clickHomePage() throws Exception {
        driver.findElement(By.xpath("//input[@value='Home Page']")).click();
    }

    public void clickAdminLogin(Application application) throws Exception {
        driver.get(application.appURL() + "/jfn?entry=admin_login");
    }

    public void clickForgotYourPassword() throws Exception {
        driver.findElement(By.id("lnk_FORGOTTEN_PASSWORD")).click();
    }

    public void setUserName(String login) throws Exception {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(login);
    }

    public void setPassword(String password) throws Exception {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void selectRealm(String realm) throws Exception {
        if (driver.getPageSource().contains("Domain")) {
            new Select(driver.findElement(By.id("realm"))).selectByVisibleText(realm);
        }
    }

    public void clickLogin() throws Exception {
        driver.findElement(By.name("LoginButton")).click();
    }

    public String getMessage() throws Exception {
        return driver.findElement(By.xpath("//span")).getText();
    }

    public MyshapeCommon unsuccessfulLogin(User user) throws Exception {
        this.setUserName(user.getLogin());
        this.setPassword(user.getPassword());
        this.clickLogin();

        return new MyshapeCommon(driver);
    }

    public String getTempPasswordFromPage() throws Exception {
        String password = driver.findElement(By.xpath("//span")).getText();
        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());

        return password.trim();
    }

    public WorkSpaceCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new WorkSpaceCommon(driver);
    }

    public String getChangePasswordOnFirstLoginMessage() throws Exception {
        System.out.println(">>" + driver.findElement(By.cssSelector("span")).getText());

        return driver.findElement(By.cssSelector("span")).getText();
    }
}
