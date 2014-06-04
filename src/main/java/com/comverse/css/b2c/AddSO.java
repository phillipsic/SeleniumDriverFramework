package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class AddSO extends B2CMenu {

    public AddSO(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Add Supplementary Offers";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail confirmAddSO() throws Exception {
        Common.assertTextOnPage(driver, "request has been submitted successfully with the order number");

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SubscriberDetail(driver);

    }

    public String getOrderNumberFromPage() throws Exception {
        String orderNumber;

        orderNumber = driver.findElement(By.xpath("//span[1]")).getText();
        String temp[];
        temp = orderNumber.split("number");
        orderNumber = temp[1].replace(".", "");
        orderNumber = orderNumber.replace(" ", "");

        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }
}
