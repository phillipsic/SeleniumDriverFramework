/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SubscriberDetailsCommon;

/**
 *
 * @author gmaroth
 */
public class SubscriberDetails extends SubscriberDetailsCommon {

    public SubscriberDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBalance viewBalanceAndRecharge() throws Exception {
        super.viewBalanceAndRecharge();
        return new ViewBalance(driver);
    }

    @Override
    public ViewCombinedHistory clickonCombinedHistory() throws Exception {
        super.clickonCombinedHistory();
        return new ViewCombinedHistory(driver);
    }

    @Override
    public ViewTransactionHistory clickHistories() throws Exception {
        super.clickHistories();
        return new ViewTransactionHistory(driver);
    }

    @Override
    public SuspendSubscriberRequestForDetails clickSuspendSubscriber() throws Exception {
        super.clickSuspendSubscriber();
        return new SuspendSubscriberRequestForDetails(driver);
    }

    @Override
    public ResumeSubscriberRequestForDetails clickResumeSubscriber() throws Exception {
        super.clickResumeSubscriber();
        return new ResumeSubscriberRequestForDetails(driver);
    }

    @Override
    public FraudlockSubscriberRequestForDetails clickFraudlockSubscriber() throws Exception {
        super.clickFraudlockSubscriber();
        return new FraudlockSubscriberRequestForDetails(driver);
    }

    @Override
    public UnlockSubscriberRequestForDetails clickUnlockSubscriber() throws Exception {
        super.clickUnlockSubscriber();
        return new UnlockSubscriberRequestForDetails(driver);
    }

    @Override
    public DisconnectSubscriberRequestForDetails clickDisconnectSubscriber() throws Exception {
        super.clickDisconnectSubscriber();
        return new DisconnectSubscriberRequestForDetails(driver);
    }

    @Override
    public PrimaryOfferDetails clickImageOfPrimaryOfferName(String primaryOfferName) throws Exception {
        super.clickImageOfPrimaryOfferName(primaryOfferName);
        return new PrimaryOfferDetails(driver);
    }

    @Override
    public AccountDetails clickAccountIDFromNavigationPanel() throws Exception {
        super.clickAccountIDFromNavigationPanel();
        return new AccountDetails(driver);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickMigrateToPostpaidSubscriber() throws Exception {
        super.clickMigrateToPostpaidSubscriber();
        return new CustomerAcquisitionCustomerDataReview(driver);
    }

    @Override
    public ModifyOfferParameters clickModifyOfferParameters() throws Exception {
        super.clickModifyOfferParameters();
        return new ModifyOfferParameters(driver);
    }

    @Override
    public SubscribeToRechargePromotionalOffers clickAddRPO() throws Exception {
        super.clickAddRPO();
        return new SubscribeToRechargePromotionalOffers(driver);
    }

    @Override
    public PrimaryOfferDetails clickRPODetails(String RPO) throws Exception {
        super.clickRPODetails(RPO);
        return new PrimaryOfferDetails(driver);
    }

    @Override
    public Shopping clickChangePO_SBAndSO() throws Exception {
        super.clickChangePO_SBAndSO();
        return new Shopping(driver);
    }
}
