package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterBillPaymentCommon extends CommonMenu {

    public RegisterBillPaymentCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Register Bill Payment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAmount(String amount) throws Exception {

        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys(amount);
    }

    public void selectPaymentMethod(String paymentmethod) throws Exception {

        driver.findElement(By.id(paymentmethod)).click();
    }

    public RegisterBillPaymentCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new RegisterBillPaymentCommon(driver);
    }

    public RegisterBillPaymentCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RegisterBillPaymentCommon(driver);
    }

    public ViewInvoicesCommon clickBackToInvoices() throws Exception {

        driver.findElement(By.xpath("//input[@name='confirm']")).click();
        return new ViewInvoicesCommon(driver);
    }
}
