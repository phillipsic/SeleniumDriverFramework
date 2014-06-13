package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddSO extends B2CMenu {

    public AddSO(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Add Supplementary Offers";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail confirmAddSO() throws Exception {
        Common.assertTextOnPage(tool, "request has been submitted successfully with the order number");

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new SubscriberDetail(tool, test, user);

    }

    public String getOrderNumberFromPage() throws Exception {
        String orderNumber;

        orderNumber = tool.driver.findElement(By.xpath("//span[1]")).getText();
        String temp[];
        temp = orderNumber.split("number");
        orderNumber = temp[1].replace(".", "");
        orderNumber = orderNumber.replace(" ", "");

        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }
}
