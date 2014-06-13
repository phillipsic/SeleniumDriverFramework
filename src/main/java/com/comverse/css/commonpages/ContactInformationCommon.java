/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ContactInformationCommon extends CommonMenu {

    public ContactInformationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Contact Information";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getFirstName() throws Exception {

        return tool.driver.findElement(By.xpath("//div[@id='mainContents']/div/div/fieldset/p[2]")).getText();

    }

    public String getLastName() throws Exception {

        return tool.driver.findElement(By.xpath("//div[@id='mainContents']/div/div/fieldset/p[3]")).getText();
    }

    public LoginInformationCommon clickViewLoginInformationLink() throws Exception {

        tool.clickUsingLinkText(tool, "View Login Information");
        return new LoginInformationCommon(tool, test, user);
    }

    public MoveMemberCommon clickMoveMember() throws Exception {

        tool.driver.findElement(By.id("youcan_MOVE_MEMBER")).click();
        return new MoveMemberCommon(tool, test, user);
    }

    public ViewHierarchyCommon clickBack() throws Exception {

        tool.driver.findElement(By.id("youcan_ON_BACK")).click();
        return new ViewHierarchyCommon(tool, test, user);
    }

    public ModifyContactInformationCommon clickModifyContactInformation() throws Exception {
        tool.driver.findElement(By.id("youcan_MODIFY_CONTACT")).click();
        return new ModifyContactInformationCommon(tool, test, user);
    }

    public ModifyEmployeeContactCommon clickModifyContact() throws Exception {

        tool.driver.findElement(By.id("youcan_MODIFY_CONTACT")).click();
        return new ModifyEmployeeContactCommon(tool, test, user);
    }

}
