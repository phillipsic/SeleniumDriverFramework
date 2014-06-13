package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class BillingManagement extends B2CMenu {

    public BillingManagement(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Billing Management";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutReview clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        return new CheckoutReview(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickIWantASeparateBillForFirstSubscriber() throws Exception {

        tool.driver.findElement(By.id("change_billing_contract_0")).click();
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickIWantASeparateBillForSecondSubscriber() throws Exception {

        tool.driver.findElement(By.id("change_billing_contract_1")).click();
        return new CheckOutBillingAccountInformation(tool, test, user);
    }
}
