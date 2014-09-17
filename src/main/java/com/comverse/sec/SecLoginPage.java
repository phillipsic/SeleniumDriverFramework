/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.sec;

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

        String currentScreen = tool.getTitle();
        String expectedScreen = "Security | Home";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void loginSecservAsSecadmin() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        clickSignIn();

        setSecservUserName(user.getLogin());
        setSecservPassword(user.getPassword());

        clickLogin();

    }

    public void setSecservUserName(String login) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + login + ")");
        tool.enterStringUsingId("loginForm:userName", login);
    }

    public void setSecservPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + password + ")");
        tool.enterStringUsingId("loginForm:password", password);
    }

    public void clickSignIn() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Sign In");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();
        String expectedScreen = "|Welcome | Please Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void clickLogin() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("loginForm:loginBtn");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();
        String expectedScreen = "Security | Home";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void clickIdentity() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//a[@id='j_id29']/span");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void clickCSS_CSR() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingXPath("//span[contains(text(),'CSS_CSR')]");
        Common.sleepForNumberOfSeconds(3);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void clickCSS_DEALER() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//a[@id='j_id42:j_id45:n-7:j_id51']/span");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();
        String expectedScreen = "Security | Identity";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void clickAddUser() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingCssSelector("input[type='button'][value='Add User']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        String currentScreen = tool.getTitle();
        String expectedScreen = "Security | Add User";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void addEmployeeCSRAdmin(String userlogin, String userpassword) throws Exception {
        test.writeInLogFile(Common.getMethodName());
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

        if (!tool.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeCSRUser(String userlogin, String userpassword) throws Exception {
        test.writeInLogFile(Common.getMethodName());
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

        if (!tool.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeBOGAdmin(String userlogin, String userpassword) throws Exception {
        test.writeInLogFile(Common.getMethodName());
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

        if (!tool.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }

    public void addEmployeeTelcoRetailerAdmin(String userlogin, String userpassword) throws Exception {
        test.writeInLogFile(Common.getMethodName());
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
        test.writeInLogFile(Common.getMethodName());
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

        if (!tool.getPageSource().contains("Successfully created")) {

            throw new Exception("Failed create");
        }

    }
}
