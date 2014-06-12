package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SelectOffers extends B2CMenu {
    public SelectOffers(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Select offers for your Subscriber";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public ConfigureOffers selectOfferByNameAndContinue(String offerName) throws Exception {
        // System.out.println("//div[contains(text(),'"+ offerName +
        // "')]/..//..//input");
        tool.driver.findElement(By.xpath("//div[contains(text(),'" + offerName + "')]/..//..//input")).click();
        // System.out.println("//div[contains(text(),'"+ offerName +
        // "')]/..//..//input");
        tool.driver.findElement(By.xpath("//input[@name='continue_button']")).click();
        return new ConfigureOffers(tool, test, user);

    }

    public AddSO selectOfferByNameAndContinueExpectingAddSO(String offerName) throws Exception {
        System.out.println("//div[contains(text(),'" + offerName + "')]/..//..//input");
        tool.driver.findElement(By.xpath("//div[contains(text(),'" + offerName + "')]/..//..//input")).click();
        System.out.println("//div[contains(text(),'" + offerName + "')]/..//..//input");
        tool.driver.findElement(By.xpath("//input[@name='continue_button']")).click();
        return new AddSO(tool, test, user);

    }

}
