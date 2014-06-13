package com.comverse.sfa;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaContact extends SFAMenu {

    public sfaContact(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Comverse ONE Billing and Active Customer Management";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setFirstNameLastnameForContact(String contactFN, String contactLN, String mainWindow, String contactWindow) throws Exception {
        tool.driver.findElement(By.id("Iyz46co_img")).click(); // open name
                                                               // detail dialog
        Common.sleepForNumberOfSeconds(3);
        Common.switchToNewWindow(tool, mainWindow, contactWindow);
        
        tool.enterStringUsingId(tool, "Ie5fc8b", contactFN); // set
                                                                       // first
                                                                       // name
        
        tool.enterStringUsingId(tool, "Ik35shv", contactLN); // set
                                                                       // last
                                                                       // name
        tool.driver.findElement(By.id("Ab0lxf")).click(); // click save
        Common.sleepForNumberOfSeconds(3);
    }

    public void clickSaveContact() throws Exception {
        tool.driver.findElement(By.id("Aowwzkq")).click();
        Common.sleepForNumberOfSeconds(3);
    }

}
