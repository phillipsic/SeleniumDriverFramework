package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditions extends B2CMenu {

    public TermsAndConditions(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Terms and Conditions";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutRegister clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new CheckoutRegister(driver);
    }

    public CheckOutBillingAccountInformation clickOkExpectingBilingAccountInformation() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CheckOutBillingAccountInformation(driver);
    }

    public CheckoutRegister clickOkExpectingCheckoutRegister() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new CheckoutRegister(driver);
    }
}
