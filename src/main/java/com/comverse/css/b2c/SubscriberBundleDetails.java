package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SubscriberBundleDetails extends B2CMenu {

    public SubscriberBundleDetails(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Subscriber Bundle Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickTermsAndConditionsTab() throws Exception {
        tool.driver.findElement(By.xpath("//em[contains(text(),'Terms And Conditions')]")).click();

    }

    public ChooseYourPrimaryOfferInThisAccountBundle clickReturnToList() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='submit'][value='Return to List']")).click();
        return new ChooseYourPrimaryOfferInThisAccountBundle(tool, test, user);
    }
}
