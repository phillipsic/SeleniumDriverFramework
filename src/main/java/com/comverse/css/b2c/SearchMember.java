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
public class SearchMember extends B2CMenu {

    

    public SearchMember(WebDriver driver) {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Search Member";


        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }
    
    public RegisterNewResidentialMember clickRegisterNewMember() throws Exception {

        driver.findElement(By.id("smnu_REGISTER_MEMBER")).click();
        return new RegisterNewResidentialMember(driver);
    }
    
    public void enterLastName(String lastName) throws Exception {

        driver.findElement(By.id("p-L1:8-L3:1470")).clear();
        driver.findElement(By.id("p-L1:8-L3:1470")).sendKeys(lastName);
    }
    
    public void clickSearchFirstLastNameButton() throws Exception {

        driver.findElement(By.xpath("//input[@value='Search']")).click();
        
    }
    public void clickFirstFoundMember() throws Exception {

        driver.findElement(By.id("lnk_MEMBER_0")).click();
        
    }
    
    public void clickOnCustomerNameLink(String lastname) throws Exception {

        driver.findElement(By.partialLinkText(lastname)).click();
        
    }
    
     public LoginInformation clickManageLogin() throws Exception {

        driver.findElement(By.linkText("Manage Login")).click();
         return new LoginInformation(driver);
    }

     public CustomerProfile clickChangeProfile() throws Exception{
	    	
	    	driver.findElement(By.linkText("Change Profile")).click();
	    	return new CustomerProfile(driver);
	    }
   
}
