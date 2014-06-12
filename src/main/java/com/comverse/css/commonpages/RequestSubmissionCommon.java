/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RequestSubmissionCommon extends CommonMenu {

    public RequestSubmissionCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Request Submission";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewHierarchyCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(tool, test, user);
    }

    public AccountDetailsCommon clickOkModifyRequestGoTOAccountDashboard() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AccountDetailsCommon(tool, test, user);
    }

    public ContactInformationCommon clickOkToSubmit() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ContactInformationCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickOkModifyRequestGoTOSubscriberDashboard() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public ProfileInformationCommon clickOkToSubmitRequest() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ProfileInformationCommon(tool, test, user);
    }

}
