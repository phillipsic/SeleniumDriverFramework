package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutReviewCommon extends CommonMenu {

    public CheckoutReviewCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Checkout Review";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutConfirmationCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@name='submitButton']")).click();
        return new CheckoutConfirmationCommon(driver);
    }

    public ImmediatePaymentCommon clickConfirmWithGoods() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new ImmediatePaymentCommon(driver);
    }
}
