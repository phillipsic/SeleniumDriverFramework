/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.Application;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;

public class HomePage {

    private final WebDriver driver;
    Prep preparation;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Myshape Consumer";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public CustomerPrerequisite selectUSDCurrency() throws Exception {

        new Select(driver.findElement(By.name("currency"))).selectByVisibleText("USD");
        driver.findElement(By.name("submit")).click();

        return new CustomerPrerequisite(driver);
    }

    public void enterUsername(String username) throws Exception {

        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(username);

    }

    public void enterPassword(String password) throws Exception {

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void enterOldPassword(String password) throws Exception {

        driver.findElement(By.id("password_old")).clear();
        driver.findElement(By.id("password_old")).sendKeys(password);
    }

    public void enterNewPassword(String password) throws Exception {

        driver.findElement(By.id("password_new")).clear();
        driver.findElement(By.id("password_new")).sendKeys(password);
    }

    public void enterNewConfirmPassword(String password) throws Exception {

        driver.findElement(By.id("password_verify")).clear();
        driver.findElement(By.id("password_verify")).sendKeys(password);
    }

    public void enterChangePasswordSecretAnswer(String secretanswer) throws Exception {

        driver.findElement(By.id("secretAnswer")).clear();
        driver.findElement(By.id("secretAnswer")).sendKeys(secretanswer);
    }

    public void enterConfirmPassword(String password) throws Exception {

        driver.findElement(By.id("confirm_password")).clear();
        driver.findElement(By.id("confirm_password")).sendKeys(password);

    }

    public void enterSecretAnswer(String secretanswer) throws Exception {

        driver.findElement(By.id("secret_answer")).clear();
        driver.findElement(By.id("secret_answer")).sendKeys(secretanswer);

    }

    public HomePage clickSignMeUp() throws Exception {

        driver.findElement(By.xpath("//input[@value='Sign Me Up']")).click();
        return new HomePage(driver);
    }

    public SubscriberDetail clickLogIn() throws Exception {

        driver.findElement(By.name("LoginButton")).click();
        return new SubscriberDetail(driver);
    }

    public WorkSpace clickLogInExpectingWorkSpace() throws Exception {

        driver.findElement(By.name("LoginButton")).click();
        return new WorkSpace(driver);
    }

    public WorkSpace clickLogInAsTelcoAdmin() throws Exception {

        driver.findElement(By.name("LoginButton")).click();
        return new WorkSpace(driver);
    }

    public WorkSpace clickChange() throws Exception {

        driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new WorkSpace(driver);
    }

    public SubscriberDetail clickChangeExpectingSubscriberDetail() throws Exception {

        driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new SubscriberDetail(driver);
    }

    public WorkSpace clickLogInWithCUP() throws Exception {

        driver.findElement(By.name("LoginButton")).click();
        return new WorkSpace(driver);
    }

    public void clickHomePage() throws Exception {

        driver.findElement(By.name("gohome")).click();

    }

    public String getLogoffMessage() throws Exception {

        return driver.findElement(By.cssSelector("span")).getText();

    }

    public String getSignMeUpMessage() throws Exception {

        return driver.findElement(By.cssSelector("span")).getText();

    }

    public void clickLogInExpectingFail() throws Exception {

        driver.findElement(By.name("LoginButton")).click();

    }

    public void clickLogInExpectingChangePassword() throws Exception {

        driver.findElement(By.name("LoginButton")).click();

    }

    public void clickShoppingLink() throws Exception {

        driver.findElement(By.linkText("Shopping")).click();

    }

    public Shopping selectAccountSegmentAll() throws Exception {

        new Select(driver.findElement(By.id("p-ACCOUNT-L4:80070"))).selectByVisibleText("All Segments");
        driver.findElement(By.name("submit")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new Shopping(driver);
    }

    public void clickActivateAccount() throws Exception {

        driver.findElement(By.linkText("Activate your account now")).click();

    }

    public void enterLastName(String lastname) throws Exception {

        driver.findElement(By.id("customer_last_name")).clear();
        driver.findElement(By.id("customer_last_name")).sendKeys(lastname);

    }

    public void enterAccountNumber(String accountnumber) throws Exception {

        driver.findElement(By.name("customer_reference")).clear();
        driver.findElement(By.name("customer_reference")).sendKeys(accountnumber);

    }

    public void clickContinueActivateAccount() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

    }

    public String getActivateAccountMessage() throws Exception {

        return driver.findElement(By.cssSelector("span")).getText();

    }

    public String getMessageFromTheSignMeUpPage() throws Exception {
        System.out.println(">>" + driver.findElement(By.cssSelector("span")).getText());
        return driver.findElement(By.cssSelector("span")).getText();

    }

    public void clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void enterLogin(String login) throws Exception {

        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(login);

    }

    public String getSuccesfulSignMeUpMessage() throws Exception {
        System.out.println(">>" + driver.findElement(By.cssSelector("span")).getText());
        return driver.findElement(By.cssSelector("span")).getText();

    }

    public WorkSpace loginAsTelcoAdmin(Application application) throws Exception {
        preparation = new Prep();
        String TelcoAdmin_password = preparation.readUsersPasswordFromIniFile("TelcoAdmin");
        String TelcoAdmin_login = preparation.readUsersUserNameFromIniFile("TelcoAdmin");

        driver.get(application.appURL() + "jfn?entry=admin_login");

        this.enterLogin(TelcoAdmin_login);
        this.enterPassword(TelcoAdmin_password);
        this.clickLogInAsTelcoAdmin();

        return new WorkSpace(driver);

    }
}
