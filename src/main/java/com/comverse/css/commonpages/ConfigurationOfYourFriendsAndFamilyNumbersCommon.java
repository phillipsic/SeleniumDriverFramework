/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigurationOfYourFriendsAndFamilyNumbersCommon extends CommonMenu {

    public ConfigurationOfYourFriendsAndFamilyNumbersCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!"Configuration of your Friends and Family numbers".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Subscriber Details, but got: " + currentScreen);

        }
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        driver.findElement(By.name("friendsAndFamilyListInputFieldsphone_number0")).clear();
        driver.findElement(By.name("friendsAndFamilyListInputFieldsphone_number0")).sendKeys(phoneNumber);
    }

    public void clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

}
