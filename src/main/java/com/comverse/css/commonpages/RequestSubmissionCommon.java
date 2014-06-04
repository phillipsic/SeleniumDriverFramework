/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Vikram Sharma
 */

public class RequestSubmissionCommon extends CommonMenu {

    public RequestSubmissionCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "Request Submission";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewHierarchyCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(driver);
    }

    public AccountDetailsCommon clickOkModifyRequestGoTOAccountDashboard() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AccountDetailsCommon(driver);
    }

    public ContactInformationCommon clickOkToSubmit() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ContactInformationCommon(driver);
    }

    public SubscriberDetailsCommon clickOkModifyRequestGoTOSubscriberDashboard() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SubscriberDetailsCommon(driver);
    }

    public ProfileInformationCommon clickOkToSubmitRequest() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ProfileInformationCommon(driver);
    }

}
