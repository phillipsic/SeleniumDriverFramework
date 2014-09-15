package com.comverse.css.b2c;

import com.comverse.common.Application;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;

public class HomePage extends B2CMenu {

    Prep preparation;

    public HomePage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Myshape Consumer";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public CustomerPrerequisite selectUSDCurrency() throws Exception {

        test.writeInLog(this.getClass().getSimpleName());

        tool.selectVisibleTextByName("currency", "USD");
        tool.clickUsingName("submit");

        return new CustomerPrerequisite(tool, test, user);
    }

    public void enterUsername(String username) throws Exception {

        tool.enterStringUsingId("login", username);

    }

    public void enterPassword(String password) throws Exception {

        tool.enterStringUsingId("password", password);
    }

    public void enterOldPassword(String password) throws Exception {

        tool.enterStringUsingId("password_old", password);
    }

    public void enterNewPassword(String password) throws Exception {

        tool.enterStringUsingId("password_new", password);
    }

    public void enterNewConfirmPassword(String password) throws Exception {

        tool.enterStringUsingId("password_verify", password);
    }

    public void enterChangePasswordSecretAnswer(String secretanswer) throws Exception {

        tool.enterStringUsingId("secretAnswer", secretanswer);
    }

    public void enterConfirmPassword(String password) throws Exception {

        tool.enterStringUsingId("confirm_password", password);

    }

    public void enterSecretAnswer(String secretanswer) throws Exception {

        tool.enterStringUsingId("secret_answer", secretanswer);

    }

    public HomePage clickSignMeUp() throws Exception {

        tool.clickUsingXPath("//input[@value='Sign Me Up']");
        return new HomePage(tool, test, user);
    }

    public SubscriberDetail clickLogIn() throws Exception {

        tool.clickUsingName("LoginButton");
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickLogInExpectingWorkSpace() throws Exception {

        tool.clickUsingName("LoginButton");
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickLogInAsTelcoAdmin() throws Exception {

        tool.clickUsingName("LoginButton");
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickChange() throws Exception {

        tool.clickUsingXPath("//input[@value='Change']");
        return new WorkSpace(tool, test, user);
    }

    public SubscriberDetail clickChangeExpectingSubscriberDetail() throws Exception {

        tool.clickUsingXPath("//input[@value='Change']");
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickLogInWithCUP() throws Exception {

        tool.clickUsingName("LoginButton");
        return new WorkSpace(tool, test, user);
    }

    public void clickHomePage() throws Exception {

        tool.clickUsingName("gohome");

    }

    public String getLogoffMessage() throws Exception {

        return tool.getTextUsingCssSelector("span");

    }

    public String getSignMeUpMessage() throws Exception {

        return tool.getTextUsingCssSelector("span");

    }

    public void clickLogInExpectingFail() throws Exception {

        tool.clickUsingName("LoginButton");

    }

    public void clickLogInExpectingChangePassword() throws Exception {

        tool.clickUsingName("LoginButton");

    }

    public void clickShoppingLink() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingLinkText("Shopping");
    }

    public Shopping selectAccountSegmentAll() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("p-ACCOUNT-L4:80070", "All Segments");
        tool.clickUsingName("submit");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new Shopping(tool, test, user);
    }

    public void clickActivateAccount() throws Exception {

        tool.clickUsingLinkText("Activate your account now");

    }

    public void enterLastName(String lastname) throws Exception {

        tool.enterStringUsingId("customer_last_name", lastname);

    }

    public void enterAccountNumber(String accountnumber) throws Exception {

        tool.enterStringUsingName("customer_reference", accountnumber);

    }

    public void clickContinueActivateAccount() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");

    }

    public String getActivateAccountMessage() throws Exception {

        return tool.getTextUsingCssSelector("span");

    }

    public String getMessageFromTheSignMeUpPage() throws Exception {
        System.out.println(">>" + tool.getTextUsingCssSelector("span"));
        return tool.getTextUsingCssSelector("span");

    }

    public void clickOK() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
    }

    public void enterLogin(String login) throws Exception {

        tool.enterStringUsingId("login", login);

    }

    public String getSuccesfulSignMeUpMessage() throws Exception {
        System.out.println(">>" + tool.getTextUsingCssSelector("span"));
        return tool.getTextUsingCssSelector("span");

    }

    public WorkSpace loginAsTelcoAdmin(Application application) throws Exception {
        preparation = new Prep();
        String TelcoAdmin_password = preparation.readUsersPasswordFromIniFile("TelcoAdmin");
        String TelcoAdmin_login = preparation.readUsersUserNameFromIniFile("TelcoAdmin");

        tool.get(application.appURL() + "jfn?entry=admin_login");

        this.enterLogin(TelcoAdmin_login);
        this.enterPassword(TelcoAdmin_password);
        this.clickLogInAsTelcoAdmin();

        return new WorkSpace(tool, test, user);

    }
}
