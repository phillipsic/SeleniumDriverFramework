/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class ModifyOfferParameters extends B2CMenu {

    public ModifyOfferParameters(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Offer Parameters";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void checkVoiceMailEnableToNo() throws Exception {
    	driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Enable')]/following-sibling::input")).click();
    }

    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
    	 driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).clear();
         driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).sendKeys(voiceMailSize);
    }

    public ModifyItemOfSubscriber clickModify() throws Exception {
        driver.findElement(By.xpath("//input[@value='Modify']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ModifyItemOfSubscriber(driver);
    }

    public String getVoiceMailSize() throws Exception {

        return driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).getAttribute("value");
    }
}
