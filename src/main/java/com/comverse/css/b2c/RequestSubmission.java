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
public class RequestSubmission extends B2CMenu {

    public RequestSubmission(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Request Submission";


        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public SearchMember clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SearchMember(driver);
    }
    
    public SubscriberDetail clickOkToConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SubscriberDetail(driver);
    }
}
