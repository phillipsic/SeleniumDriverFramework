package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SelectOffers extends B2CMenu {
	public SelectOffers(WebDriver driver) {
		super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Select offers for your Subscriber";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    
		
	}

	public ConfigureOffers selectOfferByNameAndContinue(String offerName) throws Exception{
		//System.out.println("//div[contains(text(),'"+ offerName + "')]/..//..//input");
		driver.findElement(By.xpath("//div[contains(text(),'"+ offerName + "')]/..//..//input")).click();
		//System.out.println("//div[contains(text(),'"+ offerName + "')]/..//..//input");
		driver.findElement(By.xpath("//input[@name='continue_button']")).click();
		return new ConfigureOffers(driver);
		
	}

        public AddSO selectOfferByNameAndContinueExpectingAddSO(String offerName) throws Exception{
		System.out.println("//div[contains(text(),'"+ offerName + "')]/..//..//input");
		driver.findElement(By.xpath("//div[contains(text(),'"+ offerName + "')]/..//..//input")).click();
		System.out.println("//div[contains(text(),'"+ offerName + "')]/..//..//input");
		driver.findElement(By.xpath("//input[@name='continue_button']")).click();
		return new AddSO(driver);

	}

}
