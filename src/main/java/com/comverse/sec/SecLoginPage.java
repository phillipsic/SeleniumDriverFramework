/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.sec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SecLoginPage {

    private final WebDriver driver;
    private final User user;

    public SecLoginPage(WebDriver driver, User user) {

        this.driver = driver;
        this.user = user;

        String currentScreen = driver.getTitle();
        String expectedScreen = "Security | Home";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void loginSecservAsSecadmin() throws Exception {
        clickSignIn();

        setSecservUserName(user.getLogin());
        setSecservPassword(user.getPassword());

        clickLogin();

    }

    public void setSecservUserName(String login) throws Exception {

        driver.findElement(By.id("loginForm:userName")).clear();
        driver.findElement(By.id("loginForm:userName")).sendKeys(login);
    }

    public void setSecservPassword(String password) throws Exception {

        driver.findElement(By.id("loginForm:password")).clear();
        driver.findElement(By.id("loginForm:password")).sendKeys(password);
    }

    public void clickSignIn() throws Exception {

        driver.findElement(By.linkText("Sign In")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();
        String expectedScreen = "|Welcome | Please Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickLogin() throws Exception {

        driver.findElement(By.id("loginForm:loginBtn")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();
        String expectedScreen = "Security | Home";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickIdentity() throws Exception {

        driver.findElement(By.xpath("//a[@id='j_id29']/span")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickCSS_CSR() throws Exception {
        Common.sleepForNumberOfSeconds(2);
        driver.findElement(By.xpath("//span[contains(text(),'CSS_CSR')]")).click();
        Common.sleepForNumberOfSeconds(3);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickCSS_DEALER() throws Exception {

        driver.findElement(By.xpath("//a[@id='j_id42:j_id45:n-7:j_id51']/span")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickAddUser() throws Exception {

        driver.findElement(By.cssSelector("input[type='button'][value='Add User']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        String currentScreen = driver.getTitle();
        String expectedScreen = "Security | Add User";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void addEmployeeCSRAdmin(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(driver);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("CSSCSR_CSS_CSR_ADMIN");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(10);

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeCSRUser(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(driver);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("CSSCSR_CSS_CSR_USER");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(30);

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeBOGAdmin(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(driver);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("CSSCSR_CSS_BOG_ADMIN");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(10);

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeTelcoRetailerAdmin(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(driver);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("RETAILER_TELCO_ADMIN");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(15);

        String cleanPageSource = Common.returnCleanPageSource(driver);

        if (!cleanPageSource.contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeTelcoRetailerSubscriber(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(driver);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("RETAILER_TELCO_USR");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }
}
