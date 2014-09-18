/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CheckOutBillingAccountInformation extends B2CMenu {

    public CheckOutBillingAccountInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Checkout - Billing Account Information";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public CheckoutReview clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, Common.getMethodName());
        return new CheckoutReview(tool, test, user);
    }

    public BillingManagement clickContinueExpectingBillingManagement() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, Common.getMethodName());
        return new BillingManagement(tool, test, user);
    }

    public void clickCheckRadioButton() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@id='paymentMethodCode' and @value='CHECK']");
    }

    public void clickDirectDebitRadioButton() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@id='paymentMethodCode' and @value='DIRECT_DEBIT']");
    }

    public void enterBankCode(String bankCode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + bankCode + ")");
        tool.enterStringUsingId("p-PAYMENT-L3:1360", bankCode);
    }

    public void enterBankAgencyCode(String bankAgencyCode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + bankAgencyCode + ")");
        tool.enterStringUsingId("p-PAYMENT-L3:1370", bankAgencyCode);
    }

    public void enterBankAccountNumber(String bankAccountNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + bankAccountNumber + ")");
        tool.enterStringUsingId("p-PAYMENT-L3:1380", bankAccountNumber);
    }

    public void enterOwnerLastName(String ownerLastName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + ownerLastName + ")");
        tool.enterStringUsingId("p-PAYMENT-L3:1270", ownerLastName);
    }

    public void selectAccountAttributeLanguage(String language) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + language + ")");
        tool.selectVisibleTextByID("p-ACCOUNT-L4:80000", language);
    }

    public void enterCity(String city) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + city + ")");
        tool.enterStringUsingId("city", city);
    }

    public void enterAddressLine1(String addressLine1) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + addressLine1 + ")");
        tool.enterStringUsingId("address_line_1", addressLine1);
    }

    public void enterZipPostalCode(String zipCode) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + zipCode + ")");
        tool.enterStringUsingId("zip", zipCode);
    }

    public void enterState(String state) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + state + ")");
        tool.selectVisibleTextByID("state", state);
    }
}
