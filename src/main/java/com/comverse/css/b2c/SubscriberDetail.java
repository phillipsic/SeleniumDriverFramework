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
        String currentScreen = tool.getTitle();
        String expectedScreen = "Subscriber detail";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public BillingAccountInformation clickManageBillingAccounts() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_PAYMENT_INFOS");
        return new BillingAccountInformation(tool, test, user);
    }

    public SelectModeOfRecharge clickRecharge() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Recharge");
        return new SelectModeOfRecharge(tool, test, user);
    }

    // public Shopping clickShopping() throws Exception {
    // tool.clickUsingLinkText("Shopping");
    // Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    // return new Shopping(tool, test, user);
    // }
    public ViewBalances clickBalances() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Balances");
        return new ViewBalances(tool, test, user);
    }

    public ViewBalances clickSharedBalances() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Shared balances");
        return new ViewBalances(tool, test, user);
    }

    public SelectOffers clickAddSO() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Add Supplementary Offers");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffers(tool, test, user);
    }

    public SearchMember clickMyInformationTab() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("My Information");
        return new SearchMember(tool, test, user);
    }

    public SearchOrders clickMyOrdersTab() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("My Orders");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchOrders(tool, test, user);
    }

    public RemoveOffer clickOfferRemove() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Remove");
        return new RemoveOffer(tool, test, user);
    }

    public ModifyOfferParameters clickOfferConfigure(String offerName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + offerName + ")");
        tool.clickUsingXPath("//a[contains(text(),'" + offerName + "')]/../..//a[contains(text(),'Configure')]");
        return new ModifyOfferParameters(tool, test, user);
    }

    public Identity clickUpdateContact() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//*[contains(text(),'Contact')]/..//a[contains(text(), 'Update')]");
        return new Identity(tool, test, user);
    }

    public SelectOffersForYourAccount clickSubscribeToNewOffer() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//a[contains(text(), 'Subscribe to new offers')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccount(tool, test, user);
    }

    public RemoveOffer clickRemoveAO(String offerName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + offerName + ")");
        tool.clickUsingXPath("//a[contains(text(), '" + offerName + "')]/../..//a[contains(text(), 'Remove')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveOffer(tool, test, user);
    }

    public ModifySubscriberAttributes clickConfigureAttributes() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//*[contains(text(),'Attributes')]/..//a[contains(text(), 'Configure')]");
        return new ModifySubscriberAttributes(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickMigrateToPostpaidSubscriber() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//a[contains(text(), 'Migrate to postpaid subscriber')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public String getOfferName() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getAttributeUsingXpath("//div[@id='mainContentsGrey']/div[1]/div[2]/div[3]/div[1]/div[1]/a", "value");
    }

    public ChooseYourPrimaryOffer clickChangeOffer() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//a[contains(text(), 'Change Offer')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public SubscriberStatusHistory clickStatusHistory() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//a[contains(text(), 'View Status History')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberStatusHistory(tool, test, user);
    }

}
