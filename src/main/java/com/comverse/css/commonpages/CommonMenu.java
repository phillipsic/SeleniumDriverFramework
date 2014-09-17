package com.comverse.css.commonpages;

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
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Manage Account");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new IdentifyCustomerCommon(tool, test, user);
    }

    public LoginInformationCommon clickMyInformation() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_INFO");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new LoginInformationCommon(tool, test, user);
    }

    public SearchRequestsCommon clickRequests() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Requests");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchRequestsCommon(tool, test, user);
    }

    public ViewHierarchyCommon clickHierarchy() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_HIERARCHY");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(tool, test, user);
    }

    public LevelLegalContactCommon clickHierarchyCSR() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_HIERARCHY");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new LevelLegalContactCommon(tool, test, user);
    }

    public MyshapeCommon clickLogout() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_LOGOUT");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyshapeCommon(tool, test, user);
    }

    public ComverseOneSingleSignOn clickLogoutExpectingSSO() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_LOGOUT");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ComverseOneSingleSignOn(tool, test, user);
    }

    public AccountDetailsCommon clickAccounts() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_ACCOUNTS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public ResumeAParkedBasketCommon clickBasket() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_BASKET");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ResumeAParkedBasketCommon(tool, test, user);
    }

    public void clickCartIcon() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("imIconShoppingCart");
    }

    public MyBasketCommon clickViewBasket() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("View Basket");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

    public PersonManagementCommon clickPersonManagement() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_PERSON_VIEW");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new PersonManagementCommon(tool, test, user);
    }

    public WorkSpaceCommon clickHome() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_HOME");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new WorkSpaceCommon(tool, test, user);
    }

    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_BILLS_PAYMENTS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewInvoicesCommon(tool, test, user);
    }

    public ContactInformationCommon clickUserInformation() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_INFO");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ContactInformationCommon(tool, test, user);
    }

    public ViewTransactionHistoryCommon clickHistories() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_HISTORIES");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(tool, test, user);
    }

    public ViewHierarchyCommon clickCustomerHierarchy() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_HIERARCHY");
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
