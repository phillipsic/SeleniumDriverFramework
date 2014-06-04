package com.comverse.css.b2c;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author indranil
 */
public class SubscriberBundleDetails extends B2CMenu {

    

    public SubscriberBundleDetails(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Subscriber Bundle Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    
    public void clickTermsAndConditionsTab() throws Exception {
    	driver.findElement(By.xpath("//em[contains(text(),'Terms And Conditions')]")).click();
    	
    }
    public ChooseYourPrimaryOfferInThisAccountBundle clickReturnToList()throws Exception {
    	driver.findElement(By.cssSelector("input[type='submit'][value='Return to List']")).click();
    	return new ChooseYourPrimaryOfferInThisAccountBundle(driver);
    }
}
