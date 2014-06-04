/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class SubscriberDetail extends B2CMenu {

    public SubscriberDetail(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Subscriber detail";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public BillingAccountInformation clickManageBillingAccounts() throws Exception {

        driver.findElement(By.id("smnu_PAYMENT_INFOS")).click();
        return new BillingAccountInformation(driver);
    }

    public SelectModeOfRecharge clickRecharge() throws Exception {

        driver.findElement(By.linkText("Recharge")).click();
        return new SelectModeOfRecharge(driver);
    }

    // public Shopping clickShopping() throws Exception {
    // driver.findElement(By.linkText("Shopping")).click();
    // Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    // return new Shopping(driver);
    // }
    public ViewBalances clickBalances() throws Exception {

        driver.findElement(By.linkText("Balances")).click();
        return new ViewBalances(driver);
    }

    public ViewBalances clickSharedBalances() throws Exception {

        driver.findElement(By.linkText("Shared balances")).click();
        return new ViewBalances(driver);
    }

    public SelectOffers clickAddSO() throws Exception {

        driver.findElement(By.linkText("Add Supplementary Offers")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SelectOffers(driver);
    }

    public SearchMember clickMyInformationTab() throws Exception {

        driver.findElement(By.linkText("My Information")).click();
        return new SearchMember(driver);
    }

    public SearchOrders clickMyOrdersTab() throws Exception {

        driver.findElement(By.linkText("My Orders")).click();
        return new SearchOrders(driver);
    }

    public RemoveOffer clickOfferRemove() throws Exception {
        driver.findElement(By.linkText("Remove")).click();
        return new RemoveOffer(driver);
    }

    public ModifyOfferParameters clickOfferConfigure(String offerName) throws Exception {
        driver.findElement(By.xpath("//a[contains(text(),'" + offerName + "')]/../..//a[contains(text(),'Configure')]")).click();
        return new ModifyOfferParameters(driver);
    }

    public Identity clickUpdateContact() throws Exception {
        driver.findElement(By.xpath("//*[contains(text(),'Contact')]/..//a[contains(text(), 'Update')]")).click();
        return new Identity(driver);
    }

    public SelectOffersForYourAccount clickSubscribeToNewOffer() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(), 'Subscribe to new offers')]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SelectOffersForYourAccount(driver);
    }

    public RemoveOffer clickRemoveAO(String offerName) throws Exception {
        driver.findElement(By.xpath("//a[contains(text(), '" + offerName + "')]/../..//a[contains(text(), 'Remove')]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RemoveOffer(driver);
    }

    public ModifySubscriberAttributes clickConfigureAttributes() throws Exception {
        driver.findElement(By.xpath("//*[contains(text(),'Attributes')]/..//a[contains(text(), 'Configure')]")).click();
        return new ModifySubscriberAttributes(driver);
    }

    public ChooseYourPrimaryOffer clickMigrateToPostpaidSubscriber() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(), 'Migrate to postpaid subscriber')]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(driver);
    }

    public String getOfferName() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContentsGrey']/div[1]/div[2]/div[3]/div[1]/div[1]/a")).getAttribute("value");

    }

    public ChooseYourPrimaryOffer clickChangeOffer() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(), 'Change Offer')]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(driver);
    }

    public SubscriberStatusHistory clickStatusHistory() throws Exception {
        driver.findElement(By.xpath("//a[contains(text(), 'View Status History')]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberStatusHistory(driver);
    }

}
