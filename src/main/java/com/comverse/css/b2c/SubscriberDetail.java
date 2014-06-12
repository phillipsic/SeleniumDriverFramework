/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SubscriberDetail extends B2CMenu {

    public SubscriberDetail(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Subscriber detail";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public BillingAccountInformation clickManageBillingAccounts() throws Exception {

        tool.driver.findElement(By.id("smnu_PAYMENT_INFOS")).click();
        return new BillingAccountInformation(tool, test, user);
    }

    public SelectModeOfRecharge clickRecharge() throws Exception {

        tool.driver.findElement(By.linkText("Recharge")).click();
        return new SelectModeOfRecharge(tool, test, user);
    }

    // public Shopping clickShopping() throws Exception {
    // tool.driver.findElement(By.linkText("Shopping")).click();
    // Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    // return new Shopping(tool, test, user);
    // }
    public ViewBalances clickBalances() throws Exception {

        tool.driver.findElement(By.linkText("Balances")).click();
        return new ViewBalances(tool, test, user);
    }

    public ViewBalances clickSharedBalances() throws Exception {

        tool.driver.findElement(By.linkText("Shared balances")).click();
        return new ViewBalances(tool, test, user);
    }

    public SelectOffers clickAddSO() throws Exception {

        tool.driver.findElement(By.linkText("Add Supplementary Offers")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffers(tool, test, user);
    }

    public SearchMember clickMyInformationTab() throws Exception {

        tool.driver.findElement(By.linkText("My Information")).click();
        return new SearchMember(tool, test, user);
    }

    public SearchOrders clickMyOrdersTab() throws Exception {

        tool.driver.findElement(By.linkText("My Orders")).click();
        return new SearchOrders(tool, test, user);
    }

    public RemoveOffer clickOfferRemove() throws Exception {
        tool.driver.findElement(By.linkText("Remove")).click();
        return new RemoveOffer(tool, test, user);
    }

    public ModifyOfferParameters clickOfferConfigure(String offerName) throws Exception {
        tool.driver.findElement(By.xpath("//a[contains(text(),'" + offerName + "')]/../..//a[contains(text(),'Configure')]")).click();
        return new ModifyOfferParameters(tool, test, user);
    }

    public Identity clickUpdateContact() throws Exception {
        tool.driver.findElement(By.xpath("//*[contains(text(),'Contact')]/..//a[contains(text(), 'Update')]")).click();
        return new Identity(tool, test, user);
    }

    public SelectOffersForYourAccount clickSubscribeToNewOffer() throws Exception {
        tool.driver.findElement(By.xpath("//a[contains(text(), 'Subscribe to new offers')]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccount(tool, test, user);
    }

    public RemoveOffer clickRemoveAO(String offerName) throws Exception {
        tool.driver.findElement(By.xpath("//a[contains(text(), '" + offerName + "')]/../..//a[contains(text(), 'Remove')]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveOffer(tool, test, user);
    }

    public ModifySubscriberAttributes clickConfigureAttributes() throws Exception {
        tool.driver.findElement(By.xpath("//*[contains(text(),'Attributes')]/..//a[contains(text(), 'Configure')]")).click();
        return new ModifySubscriberAttributes(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickMigrateToPostpaidSubscriber() throws Exception {
        tool.driver.findElement(By.xpath("//a[contains(text(), 'Migrate to postpaid subscriber')]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public String getOfferName() throws Exception {

        return tool.driver.findElement(By.xpath("//div[@id='mainContentsGrey']/div[1]/div[2]/div[3]/div[1]/div[1]/a")).getAttribute("value");

    }

    public ChooseYourPrimaryOffer clickChangeOffer() throws Exception {
        tool.driver.findElement(By.xpath("//a[contains(text(), 'Change Offer')]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public SubscriberStatusHistory clickStatusHistory() throws Exception {
        tool.driver.findElement(By.xpath("//a[contains(text(), 'View Status History')]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberStatusHistory(tool, test, user);
    }

}
