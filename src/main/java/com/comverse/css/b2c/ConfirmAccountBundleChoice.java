/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class ConfirmAccountBundleChoice extends B2CMenu {

    

    public ConfirmAccountBundleChoice(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Confirm Account Bundle Choice";

       
        if (!expectedScreen.equals(driver.getTitle())) {
            
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SelectOffersForYourAccount clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SelectOffersForYourAccount(driver);
    }
    
     

}
