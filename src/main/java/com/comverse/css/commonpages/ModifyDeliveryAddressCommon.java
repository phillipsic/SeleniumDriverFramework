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

public class ModifyDeliveryAddressCommon extends CommonMenu {

    public ModifyDeliveryAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Delivery Address";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "country")).selectByVisibleText(country);

    }

    public void selectState(String state) throws Exception {

        new Select(tool.searchUsingID(tool, "state_region")).selectByVisibleText(state);

    }

    public void setAddressLine1(String addressline1) {

        tool.driver.findElement(By.id("address_line_1")).clear();
        tool.driver.findElement(By.id("address_line_1")).sendKeys(addressline1);

    }

    public void setAddressLine2(String addressline2) {

        tool.driver.findElement(By.id("address_line_2")).clear();
        tool.driver.findElement(By.id("address_line_2")).sendKeys(addressline2);

    }

    public void setAddressLine3(String addressline3) {

        tool.driver.findElement(By.id("address_line_3")).clear();
        tool.driver.findElement(By.id("address_line_3")).sendKeys(addressline3);

    }

    public void setAddressLine4(String addressline4) {

        tool.driver.findElement(By.id("address_line_4")).clear();
        tool.driver.findElement(By.id("address_line_4")).sendKeys(addressline4);

    }

    public void setZipCode(String zipcode) {

        tool.driver.findElement(By.id("zip_code")).clear();
        tool.driver.findElement(By.id("zip_code")).sendKeys(zipcode);

    }

    public void setCity(String city) {

        tool.driver.findElement(By.id("city")).clear();
        tool.driver.findElement(By.id("city")).sendKeys(city);

    }

    public ModifyDeliveryAddressConfirmationCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ModifyDeliveryAddressConfirmationCommon(tool, test, user);
    }
}
