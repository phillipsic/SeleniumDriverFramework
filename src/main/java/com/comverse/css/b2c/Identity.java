/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Identity extends B2CMenu {

    public Identity(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Identity";

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getFirstName() throws Exception {

        return driver.findElement(By.id("first_name")).getAttribute("value");
    }

    public String getLastName() throws Exception {

        return driver.findElement(By.id("last_name")).getAttribute("value");
    }

    public SubscriberDetail clickCancel() throws Exception {

        driver.findElement(By.xpath("//input[@value='Cancel']")).click();
        return new SubscriberDetail(driver);
    }

    public RequestSubmission clickModify() throws Exception {

        driver.findElement(By.xpath("//input[@value='Modify']")).click();
        return new RequestSubmission(driver);
    }

    public void setFirstName(String firstName) throws Exception {

        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys(firstName);
    }

    public void setLastName(String lastName) throws Exception {

        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys(lastName);

    }

}
