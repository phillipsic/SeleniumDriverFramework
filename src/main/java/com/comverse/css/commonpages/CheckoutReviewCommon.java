package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckoutReviewCommon extends CommonMenu {

    public CheckoutReviewCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Checkout Review";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutConfirmationCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@name='submitButton']")).click();
        return new CheckoutConfirmationCommon(tool, test, user);
    }

    public ImmediatePaymentCommon clickConfirmWithGoods() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new ImmediatePaymentCommon(tool, test, user);
    }
}
