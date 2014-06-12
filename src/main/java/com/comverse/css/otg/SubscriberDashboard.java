package com.comverse.css.otg;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.MyshapeCommon;

public class SubscriberDashboard extends MyshapeCommon {

    public SubscriberDashboard(AutomationTool tool, Test test, User user, String subscriberID) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = subscriberID;
        for (String currentScreenSplitted : currentScreen.split("/")) {
            currentScreen = currentScreenSplitted;
        }

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void verifyPageMobileNumber(String mobileNumber) throws Exception {
        Common.assertTextOnPage(tool, "Mobile Number: " + mobileNumber);
    }

    public void swipeTOLeftSubscriber(OTGHome otg) throws Exception {
        otg.dragAndDrop(tool.driver.findElement(By.cssSelector("h3.page-title.ng-binding")), tool.driver.findElement(By.xpath("//div[3]/div/img")));
    }

    public void clickRecharge() throws Exception {
        tool.driver.findElement(By.linkText("Recharge")).click();
        Thread.sleep(1000);
    }

    public void clickOther() throws Exception {
        tool.driver.findElement(By.linkText("Other")).click();
    }

    public void setFreeAmount(int freeAmount) throws Exception {
        tool.driver.findElement(By.xpath("//input[@type='text']")).clear();
        tool.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Integer.toString(freeAmount));
    }

    public void clickConfirm() throws Exception {
        tool.driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(2000);
    }

    public int getRemainingCredits() throws Exception {
        String remainingCredits = tool.driver.findElement(By.xpath("//html/body/div/div[3]/div[3]/div[1]/div[2]/div/div[2]/h1/span[2]")).getText();
        System.out.println("Remaining Credits : " + remainingCredits);
        return Integer.valueOf(remainingCredits.substring(1));
    }

    public void verifyNewRemainingCredits(int newCredits) throws Exception {
        String newRemainingCredits = "$" + newCredits;
        System.out.println("New Remaining Credits : " + newRemainingCredits);
        Common.assertTextOnPage(tool, newRemainingCredits);
    }

}
