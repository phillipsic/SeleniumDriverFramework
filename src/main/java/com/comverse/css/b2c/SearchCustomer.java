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
public class SearchCustomer extends B2CMenu {

    public SearchCustomer(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Search Customer";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public void enterLastName(String lastName) throws Exception {

        driver.findElement(By.id("p-L1:3-L3:1470")).clear();
        driver.findElement(By.id("p-L1:3-L3:1470")).sendKeys(lastName);
    }

    public RequestSubmission clickSearch() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Search'])[2]")).click();
        return new RequestSubmission(driver);
    }

    public SearchMember clickSearchMemberLink() throws Exception {

        driver.findElement(By.id("smnu_SEARCH_BY_MEMBER")).click();
        return new SearchMember(driver);
    }

    public ContactInformation clickOnCustomerNameLink(String lastname) throws Exception {

        driver.findElement(By.partialLinkText(lastname)).click();
        return new ContactInformation(driver);
    }

    public void clickSearchLastFirstName() throws Exception {
        driver.findElement(By.xpath("(//input[@value='Search'])[2]")).click();
    }
}
