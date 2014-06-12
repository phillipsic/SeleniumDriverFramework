/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RequestSubmission extends B2CMenu {

    public RequestSubmission(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Request Submission";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public SearchMember clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SearchMember(tool, test, user);
    }

    public SubscriberDetail clickOkToConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SubscriberDetail(tool, test, user);
    }
}
