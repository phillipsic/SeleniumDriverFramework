/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddCaseConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Add case - confirmation";

    public AddCaseConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new AccountDetailsCommon(tool, test, user);
    }

    public String getConfirmationMessage() throws Exception {

        return tool.driver.findElement(By.cssSelector("BODY")).getText();
    }

    public String getCaseID() throws Exception {

        String caseID = tool.driver.findElement(By.cssSelector("div.txt > span")).getText();

        caseID = caseID.replaceAll("[a-zA-Z \\.]", "");
        System.out.println("New Case ID : " + caseID);
        return caseID;
    }
}
