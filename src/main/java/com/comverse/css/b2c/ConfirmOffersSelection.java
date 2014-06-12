package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfirmOffersSelection extends B2CMenu {

    public ConfirmOffersSelection(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Confirm Offers Selection";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickConfirmOffer() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm Offer Personalization']")).click();
        return new MyBasket(tool, test, user);

    }

    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
        tool.driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).clear();
        tool.driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).sendKeys(voiceMailSize);
    }

}
