/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SubscriberDetail extends B2CMenu {

    public SubscriberDetail(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Subscriber detail";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public BillingAccountInformation clickManageBillingAccounts() throws Exception {

        tool.clickUsingID(tool, "smnu_PAYMENT_INFOS");
        return new BillingAccountInformation(tool, test, user);
    }

    public SelectModeOfRecharge clickRecharge() throws Exception {

        tool.clickUsingLinkText(tool, "Recharge");
        return new SelectModeOfRecharge(tool, test, user);
    }

    // public Shopping clickShopping() throws Exception {
    // tool.clickUsingLinkText(tool, "Shopping");
    // Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    // return new Shopping(tool, test, user);
    // }
    public ViewBalances clickBalances() throws Exception {

        tool.clickUsingLinkText(tool, "Balances");
        return new ViewBalances(tool, test, user);
    }

    public ViewBalances clickSharedBalances() throws Exception {

        tool.clickUsingLinkText(tool, "Shared balances");
        return new ViewBalances(tool, test, user);
    }

    public SelectOffers clickAddSO() throws Exception {

        tool.clickUsingLinkText(tool, "Add Supplementary Offers");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffers(tool, test, user);
    }

    public SearchMember clickMyInformationTab() throws Exception {

        tool.clickUsingLinkText(tool, "My Information");
        return new SearchMember(tool, test, user);
    }

    public SearchOrders clickMyOrdersTab() throws Exception {

        tool.clickUsingLinkText(tool, "My Orders");
        return new SearchOrders(tool, test, user);
    }

    public RemoveOffer clickOfferRemove() throws Exception {
        tool.clickUsingLinkText(tool, "Remove");
        return new RemoveOffer(tool, test, user);
    }

    public ModifyOfferParameters clickOfferConfigure(String offerName) throws Exception {
        tool.clickUsingXPath(tool, "//a[contains(text(),'" + offerName + "')]/../..//a[contains(text(),'Configure')]");
        return new ModifyOfferParameters(tool, test, user);
    }

    public Identity clickUpdateContact() throws Exception {
        tool.clickUsingXPath(tool, "//*[contains(text(),'Contact')]/..//a[contains(text(), 'Update')]");
        return new Identity(tool, test, user);
    }

    public SelectOffersForYourAccount clickSubscribeToNewOffer() throws Exception {
        tool.clickUsingXPath(tool, "//a[contains(text(), 'Subscribe to new offers')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccount(tool, test, user);
    }

    public RemoveOffer clickRemoveAO(String offerName) throws Exception {
        tool.clickUsingXPath(tool, "//a[contains(text(), '" + offerName + "')]/../..//a[contains(text(), 'Remove')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveOffer(tool, test, user);
    }

    public ModifySubscriberAttributes clickConfigureAttributes() throws Exception {
        tool.clickUsingXPath(tool, "//*[contains(text(),'Attributes')]/..//a[contains(text(), 'Configure')]");
        return new ModifySubscriberAttributes(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickMigrateToPostpaidSubscriber() throws Exception {
        tool.clickUsingXPath(tool, "//a[contains(text(), 'Migrate to postpaid subscriber')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public String getOfferName() throws Exception {
        return tool.getAttributeUsingXpath(tool, "//div[@id='mainContentsGrey']/div[1]/div[2]/div[3]/div[1]/div[1]/a", "value");
    }

    public ChooseYourPrimaryOffer clickChangeOffer() throws Exception {
        tool.clickUsingXPath(tool, "//a[contains(text(), 'Change Offer')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public SubscriberStatusHistory clickStatusHistory() throws Exception {
        tool.clickUsingXPath(tool, "//a[contains(text(), 'View Status History')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberStatusHistory(tool, test, user);
    }

}
