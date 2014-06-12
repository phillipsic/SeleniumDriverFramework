/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class MyBasket extends B2CMenu {

    public MyBasket(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "My Basket";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutRegister clickCheckOut() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        return new CheckoutRegister(tool, test, user);
    }

    public TermsAndConditions clickCheckOutExpectingTermsAndConditions() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        return new TermsAndConditions(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickCheckOutExpectingCheckOutBillingAccountInformation() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public SelectOffersForYourSubscriber clickAddSupplementaryOffers() throws Exception {
        tool.driver.findElement(By.id("add_srv_0")).click();
        return new SelectOffersForYourSubscriber(tool, test, user);
    }

    public TermsAndConditions clickCheckOutWithDevices() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        return new TermsAndConditions(tool, test, user);
    }

    public ConfirmOffersSelection clickModifyOnSO(String SO) throws Exception {
        List<WebElement> Cols = tool.driver.findElements(By.tagName("td"));
        for (WebElement eachCol : Cols) {
            if (eachCol.getText().contains(SO)) {

                eachCol.findElement(By.linkText("Modify...")).click();
                break;
            }

        }
        return new ConfirmOffersSelection(tool, test, user);
    }

    public RemoveSupplementaryOffer clickRemoveOnSO(String SO) throws Exception {
        List<WebElement> Cols = tool.driver.findElements(By.tagName("td"));
        int cnter = 0;
        for (WebElement eachCol : Cols) {
            cnter++;
            if (eachCol.getText().contains(SO)) {

                break;
            }

        }
        Cols.get(cnter + 4).getText();
        Cols.get(cnter + 4).findElement(By.linkText("Remove")).click();
        return new RemoveSupplementaryOffer(tool, test, user);
    }

    public Shopping clickContinueShopping() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue Shopping']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new Shopping(tool, test, user);
    }

    public ChooseAccessories clickAddAccessory() throws Exception {
        tool.driver.findElement(By.linkText("Add Accessory")).click();
        return new ChooseAccessories(tool, test, user);
    }

    public ChooseYourHandset clickChangeDevice() throws Exception {
        tool.driver.findElement(By.linkText("Change Device")).click();
        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickChangePO() throws Exception {
        tool.driver.findElement(By.linkText("Change Primary Offer")).click();
        return new ChooseYourPrimaryOffer(tool, test, user);
    }
}
