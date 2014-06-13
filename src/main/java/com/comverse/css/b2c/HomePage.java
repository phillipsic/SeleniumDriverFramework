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
        tool.driver.findElement(By.name("submit")).click();

        return new CustomerPrerequisite(tool, test, user);
    }

    public void enterUsername(String username) throws Exception {

        tool.driver.findElement(By.id("login")).clear();
        tool.driver.findElement(By.id("login")).sendKeys(username);

    }

    public void enterPassword(String password) throws Exception {

        tool.driver.findElement(By.id("password")).clear();
        tool.driver.findElement(By.id("password")).sendKeys(password);
    }

    public void enterOldPassword(String password) throws Exception {

        tool.driver.findElement(By.id("password_old")).clear();
        tool.driver.findElement(By.id("password_old")).sendKeys(password);
    }

    public void enterNewPassword(String password) throws Exception {

        tool.driver.findElement(By.id("password_new")).clear();
        tool.driver.findElement(By.id("password_new")).sendKeys(password);
    }

    public void enterNewConfirmPassword(String password) throws Exception {

        tool.driver.findElement(By.id("password_verify")).clear();
        tool.driver.findElement(By.id("password_verify")).sendKeys(password);
    }

    public void enterChangePasswordSecretAnswer(String secretanswer) throws Exception {

        tool.driver.findElement(By.id("secretAnswer")).clear();
        tool.driver.findElement(By.id("secretAnswer")).sendKeys(secretanswer);
    }

    public void enterConfirmPassword(String password) throws Exception {

        tool.driver.findElement(By.id("confirm_password")).clear();
        tool.driver.findElement(By.id("confirm_password")).sendKeys(password);

    }

    public void enterSecretAnswer(String secretanswer) throws Exception {

        tool.driver.findElement(By.id("secret_answer")).clear();
        tool.driver.findElement(By.id("secret_answer")).sendKeys(secretanswer);

    }

    public HomePage clickSignMeUp() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Sign Me Up']")).click();
        return new HomePage(tool, test, user);
    }

    public SubscriberDetail clickLogIn() throws Exception {

        tool.driver.findElement(By.name("LoginButton")).click();
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickLogInExpectingWorkSpace() throws Exception {

        tool.driver.findElement(By.name("LoginButton")).click();
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickLogInAsTelcoAdmin() throws Exception {

        tool.driver.findElement(By.name("LoginButton")).click();
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickChange() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new WorkSpace(tool, test, user);
    }

    public SubscriberDetail clickChangeExpectingSubscriberDetail() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickLogInWithCUP() throws Exception {

        tool.driver.findElement(By.name("LoginButton")).click();
        return new WorkSpace(tool, test, user);
    }

    public void clickHomePage() throws Exception {

        tool.driver.findElement(By.name("gohome")).click();

    }

    public String getLogoffMessage() throws Exception {

        return tool.driver.findElement(By.cssSelector("span")).getText();

    }

    public String getSignMeUpMessage() throws Exception {

        return tool.driver.findElement(By.cssSelector("span")).getText();

    }

    public void clickLogInExpectingFail() throws Exception {

        tool.driver.findElement(By.name("LoginButton")).click();

    }

    public void clickLogInExpectingChangePassword() throws Exception {

        tool.driver.findElement(By.name("LoginButton")).click();

    }

    public void clickShoppingLink() throws Exception {

        tool.driver.findElement(By.linkText("Shopping")).click();

    }

    public Shopping selectAccountSegmentAll() throws Exception {

        new Select(tool.searchUsingID(tool, "p-ACCOUNT-L4:80070")).selectByVisibleText("All Segments");
        tool.driver.findElement(By.name("submit")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new Shopping(tool, test, user);
    }

    public void clickActivateAccount() throws Exception {

        tool.driver.findElement(By.linkText("Activate your account now")).click();

    }

    public void enterLastName(String lastname) throws Exception {

        tool.driver.findElement(By.id("customer_last_name")).clear();
        tool.driver.findElement(By.id("customer_last_name")).sendKeys(lastname);

    }

    public void enterAccountNumber(String accountnumber) throws Exception {

        
        tool.enterStringUsingName(tool, "customer_reference", accountnumber);

    }

    public void clickContinueActivateAccount() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();

    }

    public String getActivateAccountMessage() throws Exception {

        return tool.driver.findElement(By.cssSelector("span")).getText();

    }

    public String getMessageFromTheSignMeUpPage() throws Exception {
        System.out.println(">>" + tool.driver.findElement(By.cssSelector("span")).getText());
        return tool.driver.findElement(By.cssSelector("span")).getText();

    }

    public void clickOK() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void enterLogin(String login) throws Exception {

        tool.driver.findElement(By.id("login")).clear();
        tool.driver.findElement(By.id("login")).sendKeys(login);

    }

    public String getSuccesfulSignMeUpMessage() throws Exception {
        System.out.println(">>" + tool.driver.findElement(By.cssSelector("span")).getText());
        return tool.driver.findElement(By.cssSelector("span")).getText();

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
