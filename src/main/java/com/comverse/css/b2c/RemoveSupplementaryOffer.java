package com.comverse.css.b2c;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class RemoveSupplementaryOffer extends B2CMenu {
	
	public RemoveSupplementaryOffer(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Remove supplementary offer";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
	
	public MyBasket ClickYes() throws Exception{
		driver.findElement(By.cssSelector("input[type='submit'][value='Yes']")).click();
		return new MyBasket(driver);
	}


}
