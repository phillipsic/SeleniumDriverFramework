package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerProfile extends B2CMenu {

    public CustomerProfile(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Customer Profile";


        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyProfileInformation clickModify() throws Exception{
    	
    	driver.findElement(By.xpath("//input[@value='Modify']")).click();
    	return new ModifyProfileInformation(driver);
    }

}
