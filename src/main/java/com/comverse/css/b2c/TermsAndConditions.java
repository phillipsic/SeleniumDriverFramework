package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class TermsAndConditions extends B2CMenu {

    public TermsAndConditions(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Terms and Conditions";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutRegister clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new CheckoutRegister(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickOkExpectingBilingAccountInformation() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public CheckoutRegister clickOkExpectingCheckoutRegister() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new CheckoutRegister(tool, test, user);
    }
}
