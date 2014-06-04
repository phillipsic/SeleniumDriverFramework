/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class ContactInformationCommon extends CommonMenu {

    public ContactInformationCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Contact Information";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getFirstName() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContents']/div/div/fieldset/p[2]")).getText();

    }

    public String getLastName() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContents']/div/div/fieldset/p[3]")).getText();
    }

    public LoginInformationCommon clickViewLoginInformationLink() throws Exception {

        driver.findElement(By.linkText("View Login Information")).click();
        return new LoginInformationCommon(driver);
    }

    public MoveMemberCommon clickMoveMember() throws Exception {

        driver.findElement(By.id("youcan_MOVE_MEMBER")).click();
        return new MoveMemberCommon(driver);
    }

    public ViewHierarchyCommon clickBack() throws Exception {

        driver.findElement(By.id("youcan_ON_BACK")).click();
        return new ViewHierarchyCommon(driver);
    }

    public ModifyContactInformationCommon clickModifyContactInformation() throws Exception {
        driver.findElement(By.id("youcan_MODIFY_CONTACT")).click();
        return new ModifyContactInformationCommon(driver);
    }

    public ModifyEmployeeContactCommon clickModifyContact() throws Exception {

        driver.findElement(By.id("youcan_MODIFY_CONTACT")).click();
        return new ModifyEmployeeContactCommon(driver);
    }

}
