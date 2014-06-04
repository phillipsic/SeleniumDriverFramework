/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comverse.css.common.Common;

public class MyBasket extends B2CMenu {

    public MyBasket(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "My Basket";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutRegister clickCheckOut() throws Exception {

        driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        return new CheckoutRegister(driver);
    }

    public TermsAndConditions clickCheckOutExpectingTermsAndConditions() throws Exception {

        driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        return new TermsAndConditions(driver);
    }

    public CheckOutBillingAccountInformation clickCheckOutExpectingCheckOutBillingAccountInformation() throws Exception {

        driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CheckOutBillingAccountInformation(driver);
    }

    public SelectOffersForYourSubscriber clickAddSupplementaryOffers() throws Exception {
        driver.findElement(By.id("add_srv_0")).click();
        return new SelectOffersForYourSubscriber(driver);
    }

    public TermsAndConditions clickCheckOutWithDevices() throws Exception {

        driver.findElement(By.xpath("//input[@value='Checkout']")).click();
        return new TermsAndConditions(driver);
    }

    public ConfirmOffersSelection clickModifyOnSO(String SO) throws Exception {
        List<WebElement> Cols = driver.findElements(By.tagName("td"));
        for (WebElement eachCol : Cols) {
            if (eachCol.getText().contains(SO)) {

                eachCol.findElement(By.linkText("Modify...")).click();
                break;
            }

        }
        return new ConfirmOffersSelection(driver);
    }

    public RemoveSupplementaryOffer clickRemoveOnSO(String SO) throws Exception {
        List<WebElement> Cols = driver.findElements(By.tagName("td"));
        int cnter = 0;
        for (WebElement eachCol : Cols) {
            cnter++;
            if (eachCol.getText().contains(SO)) {

                break;
            }

        }
        Cols.get(cnter + 4).getText();
        Cols.get(cnter + 4).findElement(By.linkText("Remove")).click();
        return new RemoveSupplementaryOffer(driver);
    }

    public Shopping clickContinueShopping() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue Shopping']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new Shopping(driver);
    }

    public ChooseAccessories clickAddAccessory() throws Exception {
        driver.findElement(By.linkText("Add Accessory")).click();
        return new ChooseAccessories(driver);
    }

    public ChooseYourHandset clickChangeDevice() throws Exception {
        driver.findElement(By.linkText("Change Device")).click();
        return new ChooseYourHandset(driver);
    }

    public ChooseYourPrimaryOffer clickChangePO() throws Exception {
        driver.findElement(By.linkText("Change Primary Offer")).click();
        return new ChooseYourPrimaryOffer(driver);
    }
}
