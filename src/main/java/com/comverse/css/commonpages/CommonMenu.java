package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;
import com.comverse.css.common.Person;
import com.comverse.css.common.Subscriber;
import com.comverse.sec.ComverseOneSingleSignOn;

public class CommonMenu extends Main {

    public Account account;
    public Person person;
    public Person person2;
    public Person person3;
    public Subscriber subscriber;
    String uniqueTimeStamp;

    public CommonMenu(AutomationTool tool, Test test, User user) throws Exception {
        this.tool = tool;
        this.test = test;
        this.user = user;
        uniqueTimeStamp = Common.generateTimeStamp();
    }

    public IdentifyCustomerCommon gotoManageAccount() throws Exception {
        tool.clickUsingLinkText(tool, "Manage Account");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new IdentifyCustomerCommon(tool, test, user);
    }

    public LoginInformationCommon clickMyInformation() throws Exception {
        tool.driver.findElement(By.id("mnu_INFO")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new LoginInformationCommon(tool, test, user);
    }

    public SearchRequestsCommon clickRequests() throws Exception {
        tool.clickUsingLinkText(tool, "Requests");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchRequestsCommon(tool, test, user);
    }

    public ViewHierarchyCommon clickHierarchy() throws Exception {
        tool.driver.findElement(By.id("mnu_HIERARCHY")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(tool, test, user);
    }

    public LevelLegalContactCommon clickHierarchyCSR() throws Exception {
        tool.driver.findElement(By.id("mnu_HIERARCHY")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new LevelLegalContactCommon(tool, test, user);
    }

    public MyshapeCommon clickLogout() throws Exception {
        tool.driver.findElement(By.id("mnu_LOGOUT")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyshapeCommon(tool, test, user);
    }

    public ComverseOneSingleSignOn clickLogoutExpectingSSO() throws Exception {
        tool.driver.findElement(By.id("mnu_LOGOUT")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ComverseOneSingleSignOn(tool, test, user);
    }

    public AccountDetailsCommon clickAccounts() throws Exception {
        tool.driver.findElement(By.id("mnu_ACCOUNTS")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public ResumeAParkedBasketCommon clickBasket() throws Exception {
        tool.driver.findElement(By.id("mnu_BASKET")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ResumeAParkedBasketCommon(tool, test, user);
    }

    public void clickCartIcon() {
        tool.driver.findElement(By.id("imIconShoppingCart")).click();
    }

    public MyBasketCommon clickViewBasket() throws Exception {
        tool.clickUsingLinkText(tool, "View Basket");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

    public PersonManagementCommon clickPersonManagement() throws Exception {
        tool.driver.findElement(By.id("mnu_PERSON_VIEW")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new PersonManagementCommon(tool, test, user);
    }

    public WorkSpaceCommon clickHome() throws Exception {
        tool.driver.findElement(By.id("mnu_HOME")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new WorkSpaceCommon(tool, test, user);
    }

    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        tool.driver.findElement(By.id("mnu_BILLS_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewInvoicesCommon(tool, test, user);
    }

    public ContactInformationCommon clickUserInformation() throws Exception {
        tool.driver.findElement(By.id("mnu_INFO")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ContactInformationCommon(tool, test, user);
    }

    public ViewTransactionHistoryCommon clickHistories() throws Exception {
        tool.driver.findElement(By.id("mnu_HISTORIES")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(tool, test, user);
    }

    public ViewHierarchyCommon clickCustomerHierarchy() throws Exception {
        tool.driver.findElement(By.id("mnu_HIERARCHY")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(tool, test, user);
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson3(Person person3) {
        this.person3 = person3;
    }

    public Person getPerson3() {
        return person3;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }
}
