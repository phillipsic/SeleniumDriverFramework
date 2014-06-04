package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmModifyProfileInformation  extends B2CMenu {

    public ConfirmModifyProfileInformation(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Confirm Modify Profile Information";


        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    public void clickOK() throws Exception{
    	
    	driver.findElement(By.xpath("//input[@value='OK']")).click();
    	
    }

}
