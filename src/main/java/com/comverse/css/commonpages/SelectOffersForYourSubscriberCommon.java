/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SelectOffersForYourSubscriberCommon extends CommonMenu {

    static String expectedScreen = "Select offers for your Subscriber";

    public SelectOffersForYourSubscriberCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectOffersForSubscriber(String... SOTable) throws Exception {
        if (SOTable != null) {
            for (String SOName : SOTable) {
                tool.driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input")).click();
            }
        }
    }

    public SupplementaryOfferDetailsCommon clickOfferDetail(String SOName) throws Exception {
        tool.driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../a")).click();
        return new SupplementaryOfferDetailsCommon(tool, test, user);
    }

    public ConfigureOffersCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureOffersCommon(tool, test, user);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public SwapImpactCommon clickContinueExpectingSwapImpact() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SwapImpactCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public MyBasketCommon clickPrevious() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='< Previous'")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public MyBasketCommon clickCancel() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Cancel'")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public void clickOfferDetailOnPopUp(String SOName) throws Exception {
        tool.driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../a")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void clickClose() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Close']")).click();

    }

}
