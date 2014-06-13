/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SearchMember extends B2CMenu {

    public SearchMember(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Search Member";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public RegisterNewResidentialMember clickRegisterNewMember() throws Exception {

        tool.driver.findElement(By.id("smnu_REGISTER_MEMBER")).click();
        return new RegisterNewResidentialMember(tool, test, user);
    }

    public void enterLastName(String lastName) throws Exception {

        tool.enterStringUsingId(tool, "p-L1:8-L3:1470", lastName);
    }

    public void clickSearchFirstLastNameButton() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Search']");

    }

    public void clickFirstFoundMember() throws Exception {

        tool.driver.findElement(By.id("lnk_MEMBER_0")).click();

    }

    public void clickOnCustomerNameLink(String lastname) throws Exception {

        tool.clickUsingPartialLinkText(tool, lastname);

    }

    public LoginInformation clickManageLogin() throws Exception {

        tool.clickUsingLinkText(tool, "Manage Login");
        return new LoginInformation(tool, test, user);
    }

    public CustomerProfile clickChangeProfile() throws Exception {

        tool.clickUsingLinkText(tool, "Change Profile");
        return new CustomerProfile(tool, test, user);
    }

}
