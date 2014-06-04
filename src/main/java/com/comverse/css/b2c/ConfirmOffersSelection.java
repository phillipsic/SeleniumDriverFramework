package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOffersSelection  extends B2CMenu {

    public ConfirmOffersSelection(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Confirm Offers Selection";


        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    public MyBasket clickConfirmOffer() throws Exception{
    	
    	driver.findElement(By.xpath("//input[@value='Confirm Offer Personalization']")).click();
    	return new MyBasket(driver);
    	
    }
    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
   	 driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).clear();
        driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).sendKeys(voiceMailSize);
   }

}
