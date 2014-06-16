/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddEmployeeContactInformation extends B2BMenu {

    public AddEmployeeContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Add Employee - Contact Information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterFirstName(String firstName) throws Exception {

        tool.enterStringUsingId(tool, "first_name", firstName);
    }

    public void enterLastName(String lastName) throws Exception {

        tool.enterStringUsingId(tool, "last_name", lastName);
    }

    public AddEmployeeRegisterLogin clickSubmit() throws Exception {

        tool.clickUsingCssSelector(tool, "input.submit");
        return new AddEmployeeRegisterLogin(tool, test, user);
    }

    public void selectState(String homeState) throws Exception {

        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(homeState);

    }

    public void selectCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "home_country")).selectByVisibleText(country);
    }
}
