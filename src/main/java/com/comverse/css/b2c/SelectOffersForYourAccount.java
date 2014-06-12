/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SelectOffersForYourAccount extends B2CMenu {

    public SelectOffersForYourAccount(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Select offers for your Account";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectOffersForAccount(String... SOTable) throws Exception {

        if (SOTable != null) {
            for (String SOName : SOTable) {

                tool.driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input")).click();
            }
        }

    }

    public EnterYourSubscriptionDetails clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public AddAccountOffers clickContinueToAddAO() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddAccountOffers(tool, test, user);
    }

}
