package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.common.Main;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;
import com.comverse.css.common.Person;
import com.comverse.css.common.Subscriber;
import com.comverse.sec.ComverseOneSingleSignOn;

public class CommonMenu extends Main {

    public WebDriver driver;
    public Account account;
    public Person person;
    public Person person2;
    public Person person3;
    public Subscriber subscriber;
    String uniqueTimeStamp;

    public CommonMenu(WebDriver driver) throws Exception {
        this.driver = driver;
        uniqueTimeStamp = Common.generateTimeStamp();
    }

    public IdentifyCustomerCommon gotoManageAccount() throws Exception {
        driver.findElement(By.linkText("Manage Account")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new IdentifyCustomerCommon(driver);
    }

    public LoginInformationCommon clickMyInformation() throws Exception {
        driver.findElement(By.id("mnu_INFO")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new LoginInformationCommon(driver);
    }

    public SearchRequestsCommon clickRequests() throws Exception {
        driver.findElement(By.linkText("Requests")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SearchRequestsCommon(driver);
    }

    public ViewHierarchyCommon clickHierarchy() throws Exception {
        driver.findElement(By.id("mnu_HIERARCHY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(driver);
    }

    public LevelLegalContactCommon clickHierarchyCSR() throws Exception {
        driver.findElement(By.id("mnu_HIERARCHY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new LevelLegalContactCommon(driver);
    }

    public MyshapeCommon clickLogout() throws Exception {
        driver.findElement(By.id("mnu_LOGOUT")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyshapeCommon(driver);
    }

    public ComverseOneSingleSignOn clickLogoutExpectingSSO() throws Exception {
        driver.findElement(By.id("mnu_LOGOUT")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ComverseOneSingleSignOn(driver);
    }

    public AccountDetailsCommon clickAccounts() throws Exception {
        driver.findElement(By.id("mnu_ACCOUNTS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public ResumeAParkedBasketCommon clickBasket() throws Exception {
        driver.findElement(By.id("mnu_BASKET")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ResumeAParkedBasketCommon(driver);
    }

    public void clickCartIcon() {
        driver.findElement(By.id("imIconShoppingCart")).click();
    }

    public MyBasketCommon clickViewBasket() throws Exception {
        driver.findElement(By.linkText("View Basket")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasketCommon(driver);
    }

    public PersonManagementCommon clickPersonManagement() throws Exception {
        driver.findElement(By.id("mnu_PERSON_VIEW")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new PersonManagementCommon(driver);
    }

    public WorkSpaceCommon clickHome() throws Exception {
        driver.findElement(By.id("mnu_HOME")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new WorkSpaceCommon(driver);
    }

    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        driver.findElement(By.id("mnu_BILLS_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewInvoicesCommon(driver);
    }

    public ContactInformationCommon clickUserInformation() throws Exception {
        driver.findElement(By.id("mnu_INFO")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ContactInformationCommon(driver);
    }

    public ViewTransactionHistoryCommon clickHistories() throws Exception {
        driver.findElement(By.id("mnu_HISTORIES")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(driver);
    }

    public ViewHierarchyCommon clickCustomerHierarchy() throws Exception {
        driver.findElement(By.id("mnu_HIERARCHY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(driver);
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
