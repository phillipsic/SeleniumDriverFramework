/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCaseConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Add case - confirmation";

    public AddCaseConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AccountDetailsCommon(driver);
    }

    public String getConfirmationMessage() throws Exception {

        return driver.findElement(By.cssSelector("BODY")).getText();
    }

    public String getCaseID() throws Exception {

        String caseID = driver.findElement(By.cssSelector("div.txt > span")).getText();

        caseID = caseID.replaceAll("[a-zA-Z \\.]", "");
        System.out.println("New Case ID : " + caseID);
        return caseID;
    }
}
