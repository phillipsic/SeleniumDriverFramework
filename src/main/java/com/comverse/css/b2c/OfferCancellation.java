package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferCancellation extends B2CMenu {

    public OfferCancellation(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Offer Cancellation";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail ClickOk() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='OK']")).click();
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
