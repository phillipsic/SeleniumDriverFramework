/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author iphilli
 */
public class ChooseAccessories extends B2CMenu {

    

    public ChooseAccessories(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Choose Accessories";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasket(driver);
    }

    public ConfigureServiceConnectionDetails clickContinueExpectingConnectionServiceDetails() throws Exception {

//        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.name("doSubmit")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigureServiceConnectionDetails(driver);
    }
    public void setQuantityForAccessory(String Accessory,String Quantity) throws Exception {
    	WebElement quantityInputText= driver.findElement(By.xpath(".//a[contains(text(),'"+Accessory+"')]//../preceding-sibling::td[2]//input"));
    	quantityInputText.clear();
    	quantityInputText.sendKeys(Quantity);
    	
    }

}
