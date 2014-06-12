package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RemoveOffer extends B2CMenu {

    public RemoveOffer(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Remove Offer";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public OfferCancellation ClickYes() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='submit'][value='Yes']")).click();
        return new OfferCancellation(tool, test, user);
    }

}
