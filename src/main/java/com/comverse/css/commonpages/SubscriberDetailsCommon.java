/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class SubscriberDetailsCommon extends CommonMenu {

    static String expectedScreen = "Subscriber details";

    public SubscriberDetailsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        driver.findElement(By.id("mnu_BILLS_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new ViewInvoicesCommon(driver);
    }

    public void clickRefreshThisSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, SubscriberDetailsCommon.expectedScreen, "refreshSubscriber");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
    }

    public ViewBalanceCommon viewBalanceAndRecharge() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, ViewBalanceCommon.expectedScreen, "viewBalances");
        // driver.findElement(By.id("viewBalances")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewBalanceCommon(driver);
    }

    public ViewCombinedHistoryCommon clickonCombinedHistory() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, ViewCombinedHistoryCommon.expectedScreen, "viewCombinedHistory");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewCombinedHistoryCommon(driver);
    }

    public SubscriberStatusCommon clickViewSubscriberStatus() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, SubscriberStatusCommon.expectedScreen, "viewContractStatusHistory");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberStatusCommon(driver);
    }

    public YourFriendsAndFamilyNumbersCommon clickManageFriendsAndFamily() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, YourFriendsAndFamilyNumbersCommon.expectedScreen, "viewFriendsFamily");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new YourFriendsAndFamilyNumbersCommon(driver);
    }

    public CoherencyCheckCommon clickCoherencyCheckNormal() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, CoherencyCheckCommon.expectedScreen, "coherencyCheck", "coherencyNormal");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CoherencyCheckCommon(driver);
    }

    public SubscribeToRechargePromotionalOffersCommon clickAddRPO() throws Exception {
        driver.findElement(By.linkText("Add")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscribeToRechargePromotionalOffersCommon(driver);
    }

    public SelectOffersForYourSubscriberCommon clickSubscribeNewOffers() throws Exception {
        Common.clickAction2ItemIsAccessible(driver, "addService", SelectOffersForYourSubscriberCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(driver);
    }

    public ShoppingCommon clickChangePO_SBAndSO() throws Exception {
        Common.clickAction2ItemIsAccessible(driver, "changePrimaryOffer", ShoppingCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ShoppingCommon(driver);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickMigrateToPostpaidSubscriber() throws Exception {
        Common.clickAction2ItemIsAccessible(driver, "migratePre2Post", CustomerAcquisitionCustomerDataReviewCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(driver);
    }

    public SelectOffersForYourSubscriberCommon clickReconfigureSupplementaryOffers() throws Exception {
        Common.clickAction2ItemIsAccessible(driver, "reconfigureServices", SelectOffersForYourSubscriberCommon.expectedScreen);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(driver);
    }

    public ModifyContactInformationCommon clickModifyContactInformation() throws Exception {
        driver.findElement(By.cssSelector("u")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ModifyContactInformationCommon(driver);
    }

    public SubscriberIdentifiersSwapCommon clickSubscriberIdentifiersSwap() throws Exception {
        driver.findElement(By.id("modify_lines_link")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberIdentifiersSwapCommon(driver);
    }

    public ModifySubscriberAttributesCommon clickModifySubscriberDetails() throws Exception {
        driver.findElement(By.xpath("//div[2]/a/u")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ModifySubscriberAttributesCommon(driver);
    }

    public SuspendSubscriberRequestForDetailsCommon clickSuspendSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, SuspendSubscriberRequestForDetailsCommon.expectedScreen, "suspendSubscriber");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SuspendSubscriberRequestForDetailsCommon(driver);
    }

    public ResumeSubscriberRequestForDetailsCommon clickResumeSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, ResumeSubscriberRequestForDetailsCommon.expectedScreen, "resumeSubscriber");
        // driver.findElement(By.id("resumeSubscriber")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ResumeSubscriberRequestForDetailsCommon(driver);
    }

    public FraudlockSubscriberRequestForDetailsCommon clickFraudlockSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, FraudlockSubscriberRequestForDetailsCommon.expectedScreen, "fraudlockSubscriber");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new FraudlockSubscriberRequestForDetailsCommon(driver);
    }

    public UnlockSubscriberRequestForDetailsCommon clickUnlockSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, UnlockSubscriberRequestForDetailsCommon.expectedScreen, "unlockSubscriber");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new UnlockSubscriberRequestForDetailsCommon(driver);
    }

    public DisconnectSubscriberRequestForDetailsCommon clickDisconnectSubscriber() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, DisconnectSubscriberRequestForDetailsCommon.expectedScreen, "disconnectSubscriber");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new DisconnectSubscriberRequestForDetailsCommon(driver);
    }

    public PrimaryOfferDetailsCommon clickLinkOfPrimaryOfferName(String primaryOfferName) throws Exception {
        driver.findElement(By.linkText(primaryOfferName)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new PrimaryOfferDetailsCommon(driver);
    }

    public PrimaryOfferDetailsCommon clickImageOfPrimaryOfferName(String primaryOfferName) throws Exception {
        driver.findElement(By.cssSelector("a[title=\"View detail for " + primaryOfferName + "\"] > img")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new PrimaryOfferDetailsCommon(driver);
    }

    public SubscriberBundleDetailsCommon clickImageOfSubscriberBundleName(String subscriberBundleName) throws Exception {
        driver.findElement(By.cssSelector("a[title=\"View detail for " + subscriberBundleName + "\"] > img")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberBundleDetailsCommon(driver);
    }

    public AccountOfferDetailsCommon clickImageOfSupplementaryOfferName(String supplementaryOfferName) throws Exception {
        driver.findElement(By.cssSelector("a[title=\"View detail for " + supplementaryOfferName + "\"] > img")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountOfferDetailsCommon(driver);
    }

    public AccountOfferDetailsCommon clickImageOfPromotionalOfferName(String supplementaryOfferName) throws Exception {
        driver.findElement(By.cssSelector("a[title=\"View detail for " + supplementaryOfferName + "\"] > img")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountOfferDetailsCommon(driver);
    }

    public ModifyOfferParametersCommon clickModifyOfferParameters() throws Exception {
        driver.findElement(By.cssSelector("a[title=\"Modify Offer Parameters\"]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(3);
        return new ModifyOfferParametersCommon(driver);
    }

    public RemoveOfferCommon clickDeleteOffer() throws Exception {
        driver.findElement(By.linkText("Remove")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RemoveOfferCommon(driver);
    }

    public String getSubscriberStatus() throws Exception {

        String orderStatus = driver.findElement(By.xpath("//div[@id='navigationContext']/div/div[2]/div[2]")).getText();
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
        driver.findElement(By.id("AccountSearchLink")).click();
        Common.assertTextOnPage(driver, "Please enter your criteria and press search");
        driver.findElement(By.id("accountSearchButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.xpath("//td[3]/div/a")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(2);
        return new AccountDetailsCommon(driver);
    }

    public void clickSubscriberAttributesTab() throws Exception {
        driver.findElement(By.xpath("//div[@id='account_dashboard']/ul/li[2]/a/em")).click();
    }

    public void clickRefreshRPO() throws Exception {
        driver.findElement(By.id("rpoRefreshImage")).click();
        Common.sleepForNumberOfSeconds(2);
    }

    public PrimaryOfferDetailsCommon clickRPODetails(String RPO) throws Exception {
        driver.findElement(By.xpath("//a[@title='View detail for " + RPO + "']")).click();
        return new PrimaryOfferDetailsCommon(driver);
    }

   

   

    public void clickReconfigureAwardCounter() throws Exception {
        driver.findElement(By.xpath("//div/a/img")).click();
        Common.sleepForNumberOfSeconds(2);
    }

    public void clickSetAwardCounter() throws Exception {
        driver.findElement(By.id("awardCounter")).clear();
        driver.findElement(By.id("awardCounter")).sendKeys("2");
    }

    public void clickConfirmAwardCounterReconfiguration() throws Exception {
        driver.findElement(By.xpath("//span[2]/span/button")).click();
        Common.sleepForNumberOfSeconds(2);
    }

    public void clickRPOStatus() throws Exception {

        driver.findElement(By.xpath("//div[contains(text(),'Active')]//img")).click();

    }

    public void clickRefreshUntilRPOActive(String RPO) throws Exception {
        this.clickRefreshRPO();
        while (true) {

            if (driver.findElement(By.xpath("//a[contains(text(),'" + RPO + "')]/../../following-sibling::td[1]/div")).getText().contains("Active")) {
                break;
            } else {
                this.clickRefreshRPO();
            }
        }

    }

    public void clickConfirmStatusExpire() throws Exception {
        Common.sleepForNumberOfSeconds(3);
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        this.clickRefreshRPO();
    }

    public String returnRPOStatus() throws Exception {
        return driver.findElement(By.xpath("//div[contains(text(),'DIY - Get')]/../../../following-sibling::tr//a")).getText();
    }

    public void doAddSO(String SUPPLEMENTARY_OFFER) throws Exception {
        SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = this.clickReconfigureSupplementaryOffers();
        selectOffersForYourSubscriber.selectOffersForSubscriber(SUPPLEMENTARY_OFFER);
        ConfigureOffersCommon configureOffers = selectOffersForYourSubscriber.clickContinue();
        MyBasketCommon myBasket = configureOffers.clickContinueExpectingMyBasket();
        Common.assertTextOnPage(driver, SUPPLEMENTARY_OFFER);
        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();
        checkoutConfirmation.clickOkExpectingSubscriberDashboard();
        AccountDetailsCommon accountDetails = this.clickAccountIDFromNavigationPanel();
        RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
        requestsForCustomer.waitUntilFirstRequestCompletedOrFailedPOS();
        requestsForCustomer.clickToSubscriberDashboard();
        Common.assertTextOnPage(driver, SUPPLEMENTARY_OFFER);
    }

    public void doAddRPO(String RPO) throws Exception {
        SubscribeToRechargePromotionalOffersCommon subscribeToRechargePromotionalOffers = this.clickAddRPO();

        subscribeToRechargePromotionalOffers.selectOffersForSubscriber(RPO);
        Common.sleepForNumberOfSeconds(2);
        MyBasketCommon myBasket = subscribeToRechargePromotionalOffers.clickContinue();
        Common.assertTextOnPage(driver, RPO);
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
