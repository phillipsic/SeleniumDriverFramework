package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterBillPaymentCommon extends CommonMenu {

    public RegisterBillPaymentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Register Bill Payment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAmount(String amount) throws Exception {

        tool.driver.findElement(By.id("amount")).clear();
        tool.driver.findElement(By.id("amount")).sendKeys(amount);
    }

    public void selectPaymentMethod(String paymentmethod) throws Exception {

        tool.driver.findElement(By.id(paymentmethod)).click();
    }

    public RegisterBillPaymentCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new RegisterBillPaymentCommon(tool, test, user);
    }

    public RegisterBillPaymentCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RegisterBillPaymentCommon(tool, test, user);
    }

    public ViewInvoicesCommon clickBackToInvoices() throws Exception {

        tool.driver.findElement(By.xpath("//input[@name='confirm']")).click();
        return new ViewInvoicesCommon(tool, test, user);
    }
}
