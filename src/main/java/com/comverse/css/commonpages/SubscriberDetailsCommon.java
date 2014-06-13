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

public class SubscriberDetailsCommon extends CommonMenu {

    static String expectedScreen = "Subscriber details";

    public SubscriberDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        tool.driver.findElement(By.id("mnu_BILLS_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ViewInvoicesCommon(tool, test, user);
    }

    public void clickRefreshThisSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, SubscriberDetailsCommon.expectedScreen, "refreshSubscriber");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
    }

    public ViewBalanceCommon viewBalanceAndRecharge() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, ViewBalanceCommon.expectedScreen, "viewBalances");
        // tool.driver.findElement(By.id("viewBalances")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewBalanceCommon(tool, test, user);
    }

    public ViewCombinedHistoryCommon clickonCombinedHistory() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, ViewCombinedHistoryCommon.expectedScreen, "viewCombinedHistory");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCombinedHistoryCommon(tool, test, user);
    }

    public SubscriberStatusCommon clickViewSubscriberStatus() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, SubscriberStatusCommon.expectedScreen, "viewContractStatusHistory");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberStatusCommon(tool, test, user);
    }

    public YourFriendsAndFamilyNumbersCommon clickManageFriendsAndFamily() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, YourFriendsAndFamilyNumbersCommon.expectedScreen, "viewFriendsFamily");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new YourFriendsAndFamilyNumbersCommon(tool, test, user);
    }

    public CoherencyCheckCommon clickCoherencyCheckNormal() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, CoherencyCheckCommon.expectedScreen, "coherencyCheck", "coherencyNormal");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CoherencyCheckCommon(tool, test, user);
    }

    public SubscribeToRechargePromotionalOffersCommon clickAddRPO() throws Exception {
        tool.clickUsingLinkText(tool, "Add");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscribeToRechargePromotionalOffersCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickSubscribeNewOffers() throws Exception {
        Common.clickAction2ItemIsAccessible(tool, "addService", SelectOffersForYourSubscriberCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public ShoppingCommon clickChangePO_SBAndSO() throws Exception {
        Common.clickAction2ItemIsAccessible(tool, "changePrimaryOffer", ShoppingCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickMigrateToPostpaidSubscriber() throws Exception {
        Common.clickAction2ItemIsAccessible(tool, "migratePre2Post", CustomerAcquisitionCustomerDataReviewCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickReconfigureSupplementaryOffers() throws Exception {
        Common.clickAction2ItemIsAccessible(tool, "reconfigureServices", SelectOffersForYourSubscriberCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public ModifyContactInformationCommon clickModifyContactInformation() throws Exception {
        tool.clickUsingCssSelector(tool, "u");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyContactInformationCommon(tool, test, user);
    }

    public SubscriberIdentifiersSwapCommon clickSubscriberIdentifiersSwap() throws Exception {
        tool.driver.findElement(By.id("modify_lines_link")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberIdentifiersSwapCommon(tool, test, user);
    }

    public ModifySubscriberAttributesCommon clickModifySubscriberDetails() throws Exception {
        tool.driver.findElement(By.xpath("//div[2]/a/u")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifySubscriberAttributesCommon(tool, test, user);
    }

    public SuspendSubscriberRequestForDetailsCommon clickSuspendSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, SuspendSubscriberRequestForDetailsCommon.expectedScreen, "suspendSubscriber");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SuspendSubscriberRequestForDetailsCommon(tool, test, user);
    }

    public ResumeSubscriberRequestForDetailsCommon clickResumeSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, ResumeSubscriberRequestForDetailsCommon.expectedScreen, "resumeSubscriber");
        // tool.driver.findElement(By.id("resumeSubscriber")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ResumeSubscriberRequestForDetailsCommon(tool, test, user);
    }

    public FraudlockSubscriberRequestForDetailsCommon clickFraudlockSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, FraudlockSubscriberRequestForDetailsCommon.expectedScreen, "fraudlockSubscriber");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new FraudlockSubscriberRequestForDetailsCommon(tool, test, user);
    }

    public UnlockSubscriberRequestForDetailsCommon clickUnlockSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, UnlockSubscriberRequestForDetailsCommon.expectedScreen, "unlockSubscriber");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UnlockSubscriberRequestForDetailsCommon(tool, test, user);
    }

    public DisconnectSubscriberRequestForDetailsCommon clickDisconnectSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, DisconnectSubscriberRequestForDetailsCommon.expectedScreen, "disconnectSubscriber");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new DisconnectSubscriberRequestForDetailsCommon(tool, test, user);
    }

    public PrimaryOfferDetailsCommon clickLinkOfPrimaryOfferName(String primaryOfferName) throws Exception {
        tool.clickUsingLinkText(tool, primaryOfferName);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new PrimaryOfferDetailsCommon(tool, test, user);
    }

    public PrimaryOfferDetailsCommon clickImageOfPrimaryOfferName(String primaryOfferName) throws Exception {
        tool.clickUsingCssSelector(tool, "a[title=\"View detail for " + primaryOfferName + "\"] > img");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new PrimaryOfferDetailsCommon(tool, test, user);
    }

    public SubscriberBundleDetailsCommon clickImageOfSubscriberBundleName(String subscriberBundleName) throws Exception {
        tool.clickUsingCssSelector(tool, "a[title=\"View detail for " + subscriberBundleName + "\"] > img");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberBundleDetailsCommon(tool, test, user);
    }

    public AccountOfferDetailsCommon clickImageOfSupplementaryOfferName(String supplementaryOfferName) throws Exception {
        tool.clickUsingCssSelector(tool, "a[title=\"View detail for " + supplementaryOfferName + "\"] > img");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountOfferDetailsCommon(tool, test, user);
    }

    public AccountOfferDetailsCommon clickImageOfPromotionalOfferName(String supplementaryOfferName) throws Exception {
        tool.clickUsingCssSelector(tool, "a[title=\"View detail for " + supplementaryOfferName + "\"] > img");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountOfferDetailsCommon(tool, test, user);
    }

    public ModifyOfferParametersCommon clickModifyOfferParameters() throws Exception {
        tool.clickUsingCssSelector(tool, "a[title=\"Modify Offer Parameters\"]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(3);
        return new ModifyOfferParametersCommon(tool, test, user);
    }

    public RemoveOfferCommon clickDeleteOffer() throws Exception {
        tool.clickUsingLinkText(tool, "Remove");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveOfferCommon(tool, test, user);
    }

    public String getSubscriberStatus() throws Exception {

        String orderStatus = tool.driver.findElement(By.xpath("//div[@id='navigationContext']/div/div[2]/div[2]")).getText();
        return orderStatus;
    }

    public void waitUntilStatusChanged(String status) throws Exception {

        int maxIterations = 10;
        int iterationCounter = 0;
        String subscriberStatus;

        while (iterationCounter < maxIterations) {

            this.clickRefreshThisSubscriber();
            subscriberStatus = this.getSubscriberStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " :" + subscriberStatus);

            if (subscriberStatus.contains(status)) {

                System.out.println("Subscriber status changed to " + status);
                break;
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getSubscriberStatus());
        }
    }

    public AccountDetailsCommon clickAccountIDFromNavigationPanel() throws Exception {
        tool.driver.findElement(By.id("AccountSearchLink")).click();
        Common.assertTextOnPage(tool, "Please enter your criteria and press search");
        tool.driver.findElement(By.id("accountSearchButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.xpath("//td[3]/div/a")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(2);
        return new AccountDetailsCommon(tool, test, user);
    }

    public void clickSubscriberAttributesTab() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='account_dashboard']/ul/li[2]/a/em")).click();
    }

    public void clickRefreshRPO() throws Exception {
        tool.driver.findElement(By.id("rpoRefreshImage")).click();
        Common.sleepForNumberOfSeconds(2);
    }

    public PrimaryOfferDetailsCommon clickRPODetails(String RPO) throws Exception {
        tool.driver.findElement(By.xpath("//a[@title='View detail for " + RPO + "']")).click();
        return new PrimaryOfferDetailsCommon(tool, test, user);
    }

    public void clickReconfigureAwardCounter() throws Exception {
        tool.driver.findElement(By.xpath("//div/a/img")).click();
        Common.sleepForNumberOfSeconds(2);
    }

    public void clickSetAwardCounter() throws Exception {
        
        tool.enterStringUsingId(tool, "awardCounter", "2");
    }

    public void clickConfirmAwardCounterReconfiguration() throws Exception {
        tool.driver.findElement(By.xpath("//span[2]/span/button")).click();
        Common.sleepForNumberOfSeconds(2);
    }

    public void clickRPOStatus() throws Exception {

        tool.driver.findElement(By.xpath("//div[contains(text(),'Active')]//img")).click();

    }

    public void clickRefreshUntilRPOActive(String RPO) throws Exception {
        this.clickRefreshRPO();
        while (true) {

            if (tool.driver.findElement(By.xpath("//a[contains(text(),'" + RPO + "')]/../../following-sibling::td[1]/div")).getText().contains("Active")) {
                break;
            } else {
                this.clickRefreshRPO();
            }
        }

    }

    public void clickConfirmStatusExpire() throws Exception {
        Common.sleepForNumberOfSeconds(3);
        tool.driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        this.clickRefreshRPO();
    }

    public String returnRPOStatus() throws Exception {
        return tool.driver.findElement(By.xpath("//div[contains(text(),'DIY - Get')]/../../../following-sibling::tr//a")).getText();
    }

    public void doAddSO(String SUPPLEMENTARY_OFFER) throws Exception {
        SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = this.clickReconfigureSupplementaryOffers();
        selectOffersForYourSubscriber.selectOffersForSubscriber(SUPPLEMENTARY_OFFER);
        ConfigureOffersCommon configureOffers = selectOffersForYourSubscriber.clickContinue();
        MyBasketCommon myBasket = configureOffers.clickContinueExpectingMyBasket();
        Common.assertTextOnPage(tool, SUPPLEMENTARY_OFFER);
        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();
        checkoutConfirmation.clickOkExpectingSubscriberDashboard();
        AccountDetailsCommon accountDetails = this.clickAccountIDFromNavigationPanel();
        RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
        requestsForCustomer.waitUntilFirstRequestCompletedOrFailedPOS();
        requestsForCustomer.clickToSubscriberDashboard();
        Common.assertTextOnPage(tool, SUPPLEMENTARY_OFFER);
    }

    public void doAddRPO(String RPO) throws Exception {
        SubscribeToRechargePromotionalOffersCommon subscribeToRechargePromotionalOffers = this.clickAddRPO();

        subscribeToRechargePromotionalOffers.selectOffersForSubscriber(RPO);
        Common.sleepForNumberOfSeconds(2);
        MyBasketCommon myBasket = subscribeToRechargePromotionalOffers.clickContinue();
        Common.assertTextOnPage(tool, RPO);
        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();
        checkoutConfirmation.clickOkExpectingSubscriberDashboard();
        AccountDetailsCommon accountDetails = this.clickAccountIDFromNavigationPanel();
        RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
        requestsForCustomer.waitUntilFirstRequestCompletedOrFailedPOS();
        requestsForCustomer.clickToSubscriberDashboard();
        this.clickRefreshRPO();
        Common.sleepForNumberOfSeconds(2);
    }

}
