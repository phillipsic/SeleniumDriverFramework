/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SearchAddressCommon extends CommonMenu {

    public SearchAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Search Address";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "home_country")).selectByVisibleText(country);

    }

    public void setStreetName(String streetname) throws Exception {

        tool.driver.findElement(By.id("streetName")).clear();
        tool.driver.findElement(By.id("streetName")).sendKeys(streetname);

    }

    public void setCity(String city) throws Exception {

        tool.driver.findElement(By.id("home_city")).clear();
        tool.driver.findElement(By.id("home_city")).sendKeys(city);

    }

    public void setZipCode(String zipcode) throws Exception {

        tool.driver.findElement(By.id("home_zip")).clear();
        tool.driver.findElement(By.id("home_zip")).sendKeys(zipcode);

    }

    public SearchAddressCommon clickOk() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchAddressCommon(tool, test, user);
    }

    public EnterIdentificationDataCommon clickSelectAddress() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Select']")).click();
        return new EnterIdentificationDataCommon(tool, test, user);
    }

}
