/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class NonVoucherRechargeCommon extends CommonMenu {

    public NonVoucherRechargeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Non voucher recharge";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public NonVoucherRechargeReviewCommon nonVoucherRechargeByCheck(String rechargeAmount) throws Exception {
        test.writeInLog(Common.getMethodName());

        this.enterRechargeAmount(rechargeAmount);
        tool.selectVisibleTextByID("rechargeClass", "Check");
        tool.clickUsingName("payment_type");
        tool.clickUsingXPath("//input[@value='Continue']");
        return new NonVoucherRechargeReviewCommon(tool, test, user);
    }

    public void enterRechargeAmount(String rechargeAmount) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("amount", rechargeAmount);
    }

    public void selectPaymentMethodCreditCard() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='CREDIT_CARD'])");
    }

    public void selectPaymentMethodCash() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='CASH'])");
    }

    public NonVoucherRechargeCommon clickContinue() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue']");
        return new NonVoucherRechargeCommon(tool, test, user);
    }

    public NonVoucherRechargeReviewCommon clickContinueExpectingNonVoucherRechargeReview() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue']");
        return new NonVoucherRechargeReviewCommon(tool, test, user);
    }

    public void enterCardNumber(String cardNumber) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardNumber", cardNumber);
    }

    public void enterCardExpDate(String expirationDate) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardExpirationDate", expirationDate);
    }

    public void enterCardHolderLastName(String lastName) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardHolderName", lastName);
    }

    public void enterCardHolderFirstName(String firstName) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardHolderFName", firstName);
    }

    public void enterCardSecretCode(String secretCode) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardSecretCode", secretCode);
    }

    public void enterEmail(String email) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardEmail", email);
    }

    public NonVoucherRechargeReviewCommon clickSelect() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@name='select']");
        return new NonVoucherRechargeReviewCommon(tool, test, user);
    }
}
