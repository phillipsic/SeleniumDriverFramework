package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CompareDevices extends B2CMenu {

    public CompareDevices(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Compare Devices";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseYourHandset clickReturnToList() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='submit'][value='Return to List']")).click();
        return new ChooseYourHandset(tool, test, user);
    }

    public String getDevice1() throws Exception {
        return tool.driver.findElement(By.xpath("//table[@class='listTable']//th[1]")).getText();
    }

    public String getDevice2() throws Exception {
        return tool.driver.findElement(By.xpath("//table[@class='listTable']//th[2]")).getText();
    }

}
