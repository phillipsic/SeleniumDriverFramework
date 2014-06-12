/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.sec;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class SecLoginPage extends CommonMenu {

    private final User user;

    public SecLoginPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        this.user = user;

        String currentScreen = tool.driver.getTitle();
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

        tool.driver.findElement(By.id("loginForm:userName")).clear();
        tool.driver.findElement(By.id("loginForm:userName")).sendKeys(login);
    }

    public void setSecservPassword(String password) throws Exception {

        tool.driver.findElement(By.id("loginForm:password")).clear();
        tool.driver.findElement(By.id("loginForm:password")).sendKeys(password);
    }

    public void clickSignIn() throws Exception {

        tool.driver.findElement(By.linkText("Sign In")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "|Welcome | Please Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickLogin() throws Exception {

        tool.driver.findElement(By.id("loginForm:loginBtn")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Security | Home";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickIdentity() throws Exception {

        tool.driver.findElement(By.xpath("//a[@id='j_id29']/span")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickCSS_CSR() throws Exception {
        Common.sleepForNumberOfSeconds(2);
        tool.driver.findElement(By.xpath("//span[contains(text(),'CSS_CSR')]")).click();
        Common.sleepForNumberOfSeconds(3);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickCSS_DEALER() throws Exception {

        tool.driver.findElement(By.xpath("//a[@id='j_id42:j_id45:n-7:j_id51']/span")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickAddUser() throws Exception {

        tool.driver.findElement(By.cssSelector("input[type='button'][value='Add User']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Security | Add User";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void addEmployeeCSRAdmin(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(tool, test, user);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("CSSCSR_CSS_CSR_ADMIN");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(10);

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeCSRUser(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(tool, test, user);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("CSSCSR_CSS_CSR_USER");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(30);

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeBOGAdmin(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(tool, test, user);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("CSSCSR_CSS_BOG_ADMIN");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(10);

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeTelcoRetailerAdmin(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(tool, test, user);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("RETAILER_TELCO_ADMIN");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.sleepForNumberOfSeconds(15);

        String cleanPageSource = Common.returnCleanPageSource(tool);

        if (!cleanPageSource.contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeTelcoRetailerSubscriber(String userlogin, String userpassword) throws Exception {

        SecCsrAdmin secCsrAdmin = new SecCsrAdmin(tool, test, user);

        secCsrAdmin.setUserName(userlogin);
        secCsrAdmin.setFirstName("FN" + userlogin);
        secCsrAdmin.setLastName("LN" + userlogin);
        secCsrAdmin.setPassword(userpassword);
        secCsrAdmin.setRePassword(userpassword);
        secCsrAdmin.setEmail(userlogin + "@comverse.com");
        secCsrAdmin.setGroups("RETAILER_TELCO_USR");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        secCsrAdmin.clickSave();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        if (!driver.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }
}
