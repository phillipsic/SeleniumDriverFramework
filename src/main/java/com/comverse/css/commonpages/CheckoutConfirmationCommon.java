package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class CheckoutConfirmationCommon extends CommonMenu {

    public CheckoutConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Checkout Confirmation";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public WorkSpaceCommon clickOk() throws Exception {
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new WorkSpaceCommon(driver);
    }

    public AccountDetailsCommon clickOkExpectingAccountDashboard() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public SubscriberDetailsCommon clickOkExpectingSubscriberDashboard() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(driver);
    }

    public String getOrderNumberFromPage() throws Exception {
        String orderNumber;
        //        String temp[];
        //        String str = driver.getPageSource();
        //        temp = str.split("Order Number:");
        //        temp = temp[1].split("</span>");
        //        temp = temp[0].split("<span>");
        //        orderNumber = temp[1];

        orderNumber = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/span[2]")).getText();
        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }

    public String getNCAOrderNumberFromPage() throws Exception {
        String orderNumber;
        //        String temp[];
        //        String str = driver.getPageSource();
        //        temp = str.split("Order Number:");
        //        temp = temp[1].split("</span>");
        //        temp = temp[0].split("<span>");
        //        orderNumber = temp[1];

        orderNumber = driver.findElement(By.xpath("//span[2]")).getText();
        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }
}
