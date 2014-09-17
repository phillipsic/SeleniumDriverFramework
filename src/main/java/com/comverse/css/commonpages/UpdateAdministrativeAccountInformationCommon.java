/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class UpdateAdministrativeAccountInformationCommon extends CommonMenu {

    public UpdateAdministrativeAccountInformationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Update administrative account information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickConfirm() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

    public void setBillingBillDispatchMethod(String SocialSecurityNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91310", SocialSecurityNumber);
    }

    public void setBillingBillFormatOption(String PurchaseOrder) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91300", PurchaseOrder);
    }

    public void setBillingExchangeRateClass(String rateClass) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("p-param-L4:91520", rateClass);
    }

    public void setRateClass(String rateClass) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91520", rateClass);
    }

    public void setBillingTML(String BillingTML) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:81280", BillingTML);
    }

    public void setBillingVIPCode(String SICCode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:80080", SICCode);
    }

    public void setBillingBillPeriod(String SICCode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:81010", SICCode);
    }

    public void setMarketCode(String marketCode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("p-param-L4:80060", marketCode);
    }

    public void setSocialSecurityNumber(String SocialSecurityNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91260", SocialSecurityNumber);
    }

    public void setPurchaseOrder(String PurchaseOrder) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91540", PurchaseOrder);
    }

    public void setSalesCode(String SalesCode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91530", SalesCode);
    }

    public void setSecurityWord(String SecurityWord) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91070", SecurityWord);
    }

    public void setSICCode(String SICCode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-param-L4:91320", SICCode);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

}
