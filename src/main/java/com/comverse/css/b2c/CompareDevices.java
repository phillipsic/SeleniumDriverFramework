package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompareDevices  extends B2CMenu {

    public CompareDevices(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Compare Devices";


        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    public ChooseYourHandset clickReturnToList()throws Exception {
    	driver.findElement(By.cssSelector("input[type='submit'][value='Return to List']")).click();
    	return new ChooseYourHandset(driver);
    }
    public String getDevice1() throws Exception{
    	return driver.findElement(By.xpath("//table[@class='listTable']//th[1]")).getText();
    }
    public String getDevice2() throws Exception{
    	return driver.findElement(By.xpath("//table[@class='listTable']//th[2]")).getText();
    }

}
