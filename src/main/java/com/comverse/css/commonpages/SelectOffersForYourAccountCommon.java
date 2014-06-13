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

public class SelectOffersForYourAccountCommon extends CommonMenu {

    public SelectOffersForYourAccountCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Select offers for your Account";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureOffersCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureOffersCommon(tool, test, user);
    }

    public MyBasketCommon clickContinueNoConfiguration() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public MyBasketCommon clickPrevious() throws Exception {
        tool.clickUsingCssSelector(tool, "input.submitGrey");
        return new MyBasketCommon(tool, test, user);
    }

    public void selectAccountOfferByName(String accountOfferName) throws Exception {
        tool.driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + accountOfferName + "')]/../../td/input")).click();
    }

    public AccountOfferDetailsCommon clickOfferDetail(String accountOfferName) throws Exception {
        tool.driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + accountOfferName + "')]/../a")).click();
        return new AccountOfferDetailsCommon(tool, test, user);
    }

    public void clickOfferDetailAndPopUp(String accountOfferName) throws Exception {
        tool.driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + accountOfferName + "')]/../a")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

    }
}
