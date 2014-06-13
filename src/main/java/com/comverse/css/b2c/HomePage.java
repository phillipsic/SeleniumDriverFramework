/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.Application;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;

public class HomePage extends B2CMenu {

    Prep preparation;

    public HomePage(AutomationTool tool, Test test, User user) {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Myshape Consumer";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public CustomerPrerequisite selectUSDCurrency() throws Exception {

        new Select(tool.searchUsingName(tool, "currency")).selectByVisibleText("USD");
        tool.clickUsingName(tool, "submit");

        return new CustomerPrerequisite(tool, test, user);
    }

    public void enterUsername(String username) throws Exception {

        
        tool.enterStringUsingId(tool, "login", username);

    }

    public void enterPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "password", password);
    }

    public void enterOldPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "password_old", password);
    }

    public void enterNewPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "password_new", password);
    }

    public void enterNewConfirmPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "password_verify", password);
    }

    public void enterChangePasswordSecretAnswer(String secretanswer) throws Exception {

        
        tool.enterStringUsingId(tool, "secretAnswer", secretanswer);
    }

    public void enterConfirmPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "confirm_password", password);

    }

    public void enterSecretAnswer(String secretanswer) throws Exception {

        
        tool.enterStringUsingId(tool, "secret_answer", secretanswer);

    }

    public HomePage clickSignMeUp() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Sign Me Up']");
        return new HomePage(tool, test, user);
    }

    public SubscriberDetail clickLogIn() throws Exception {

        tool.clickUsingName(tool, "LoginButton");
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickLogInExpectingWorkSpace() throws Exception {

        tool.clickUsingName(tool, "LoginButton");
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickLogInAsTelcoAdmin() throws Exception {

        tool.clickUsingName(tool, "LoginButton");
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickChange() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Change']");
        return new WorkSpace(tool, test, user);
    }

    public SubscriberDetail clickChangeExpectingSubscriberDetail() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Change']");
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickLogInWithCUP() throws Exception {

        tool.clickUsingName(tool, "LoginButton");
        return new WorkSpace(tool, test, user);
    }

    public void clickHomePage() throws Exception {

        tool.clickUsingName(tool, "gohome");

    }

    public String getLogoffMessage() throws Exception {

        return tool.getTextUsingCssSelector(tool, "span");

    }

    public String getSignMeUpMessage() throws Exception {

        return tool.getTextUsingCssSelector(tool, "span");

    }

    public void clickLogInExpectingFail() throws Exception {

        tool.clickUsingName(tool, "LoginButton");

    }

    public void clickLogInExpectingChangePassword() throws Exception {

        tool.clickUsingName(tool, "LoginButton");

    }

    public void clickShoppingLink() throws Exception {

        tool.clickUsingLinkText(tool, "Shopping");

    }

    public Shopping selectAccountSegmentAll() throws Exception {

        new Select(tool.searchUsingID(tool, "p-ACCOUNT-L4:80070")).selectByVisibleText("All Segments");
        tool.clickUsingName(tool, "submit");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new Shopping(tool, test, user);
    }

    public void clickActivateAccount() throws Exception {

        tool.clickUsingLinkText(tool, "Activate your account now");

    }

    public void enterLastName(String lastname) throws Exception {

        
        tool.enterStringUsingId(tool, "customer_last_name", lastname);

    }

    public void enterAccountNumber(String accountnumber) throws Exception {

        
        tool.enterStringUsingName(tool, "customer_reference", accountnumber);

    }

    public void clickContinueActivateAccount() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");

    }

    public String getActivateAccountMessage() throws Exception {

        return tool.getTextUsingCssSelector(tool, "span");

    }

    public String getMessageFromTheSignMeUpPage() throws Exception {
        System.out.println(">>" + tool.driver.findElement(By.cssSelector("span")).getText());
        return tool.getTextUsingCssSelector(tool, "span");

    }

    public void clickOK() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
    }

    public void enterLogin(String login) throws Exception {

        
        tool.enterStringUsingId(tool, "login", login);

    }

    public String getSuccesfulSignMeUpMessage() throws Exception {
        System.out.println(">>" + tool.driver.findElement(By.cssSelector("span")).getText());
        return tool.getTextUsingCssSelector(tool, "span");

    }

    public WorkSpace loginAsTelcoAdmin(Application application) throws Exception {
        preparation = new Prep();
        String TelcoAdmin_password = preparation.readUsersPasswordFromIniFile("TelcoAdmin");
        String TelcoAdmin_login = preparation.readUsersUserNameFromIniFile("TelcoAdmin");

        tool.driver.get(application.appURL() + "jfn?entry=admin_login");

        this.enterLogin(TelcoAdmin_login);
        this.enterPassword(TelcoAdmin_password);
        this.clickLogInAsTelcoAdmin();

        return new WorkSpace(tool, test, user);

    }
}
