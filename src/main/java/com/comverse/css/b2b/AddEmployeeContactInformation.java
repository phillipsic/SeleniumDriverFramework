/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddEmployeeContactInformation extends B2BMenu {

    public AddEmployeeContactInformation(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Add Employee - Contact Information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterFirstName(String firstName) throws Exception {

        tool.driver.findElement(By.id("first_name")).clear();
        tool.driver.findElement(By.id("first_name")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("last_name")).clear();
        tool.driver.findElement(By.id("last_name")).sendKeys(lastName);
    }

    public AddEmployeeRegisterLogin clickSubmit() throws Exception {

        tool.driver.findElement(By.cssSelector("input.submit")).click();
        return new AddEmployeeRegisterLogin(tool, test, user);
    }

    public void selectState(String homeState) throws Exception {

        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(homeState);

    }

    public void selectCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "home_country")).selectByVisibleText(country);
    }
}
