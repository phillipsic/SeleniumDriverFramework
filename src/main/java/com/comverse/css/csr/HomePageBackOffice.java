/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.HomePageBackOfficeCommon;

public class HomePageBackOffice extends HomePageBackOfficeCommon {

    public HomePageBackOffice(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Welcome to Your Workspace";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public InventoryAdministration clickBackOffice() throws Exception {

        tool.driver.findElement(By.id("mnu_BACK_OFFICE")).click();

        return new InventoryAdministration(tool, test, user);

    }

}
